package org.learn.log.controller;

import lombok.RequiredArgsConstructor;
import org.learn.log.service.AopLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class AopLogController {
  private final AopLogService logService;

  @GetMapping("{message}")
  public String sayHi(@PathVariable("message") String message) {
    return logService.sayHi(message);
  }
}
