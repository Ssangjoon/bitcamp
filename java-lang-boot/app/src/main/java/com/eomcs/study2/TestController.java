package com.eomcs.study2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @RequestMapping
  public String m1() {
    return "/test/m1";
  }

}
