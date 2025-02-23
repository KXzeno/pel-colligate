package com.karnovah.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColligateController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @PostMapping("/colligate")
  public Colligate colligate(@RequestBody String val) {
    return new Colligate(counter.incrementAndGet(), String.format(template, val));
  }
}
