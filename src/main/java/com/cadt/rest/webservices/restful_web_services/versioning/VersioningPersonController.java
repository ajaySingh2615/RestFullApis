package com.cadt.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

  @GetMapping("/v1/person")
  public PersonV1 getFirstVersionOfPerson() {
    return new PersonV1("Ajay Singh");
  }

  @GetMapping("/v2/person")
  public PersonV2 getSecondVersionOfPerson() {
    return new PersonV2(new Name("Ajay", "Singh"));
  }

  @GetMapping(path = "/person", params = "version=1")
  public PersonV1 getFirstVersionOfPersonRequestParameter() {
    return new PersonV1("Ajay Singh");
  }

  @GetMapping(path = "/person", params = "version=2")
  public PersonV2 getSecondVersionOfPersonRequestParameters() {
    return new PersonV2(new Name("Ajay", "Singh"));
  }

  @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
  public PersonV1 getFirstVersionOfPersonRequestHeader() {
    return new PersonV1("Ajay Singh");
  }
}
