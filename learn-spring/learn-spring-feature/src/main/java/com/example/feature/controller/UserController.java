package com.example.feature.controller;

import com.example.feature.annotation.TestAnnotation;
import com.example.feature.service.UserService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
@RestController
//@TestAnnotation
public class UserController {

  @Resource
  private UserService userService;

  @GetMapping("/getUser")
  public String getUser(){
    userService.register("xpxpxp");
    return "user success";
  }

}
