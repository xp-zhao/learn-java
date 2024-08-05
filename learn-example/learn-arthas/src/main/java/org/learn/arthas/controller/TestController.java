package org.learn.arthas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiaoping
 * @date 2024-8-5
 */
@RestController
@RequestMapping("/arthas")
public class TestController {
  @GetMapping("/get")
  public String get() {
    return "get success";
  }
}
