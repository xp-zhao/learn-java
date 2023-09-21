package com.example.feature.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
@RestController
public class OrderController {
  @GetMapping("/getOrder")
  public String getOrder(){
    return "order success";
  }
}
