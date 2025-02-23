package com.karnovah.pel;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/test")
  public Colligate test(@RequestParam(value = "name", defaultValue = "zero") String name) {
    return new Colligate(counter.incrementAndGet(), String.format(template, name));
  }
}
