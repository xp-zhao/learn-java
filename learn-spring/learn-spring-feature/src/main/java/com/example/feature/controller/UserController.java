package com.example.feature.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.feature.controller.entity.UserEntity;
import com.example.feature.service.UserService;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaoxiaoping @Description: @Date
 */
@Slf4j
@Validated
@RestController
// @TestAnnotation
public class UserController {

  @Resource private UserService userService;

  @GetMapping("/getUser")
  public String getUser(@RequestParam("userId") Integer userId) {
    Assert.isTrue(ObjectUtil.isNotNull(userId), "userId 不能为空");
    userService.register("xpxpxp");
    return "user success";
  }

  @PostMapping("/saveUser")
  public String saveUser(@RequestBody @Validated UserEntity user) {
    log.info("保存用户成功, userId: {}", user.getUserId());
    return user.getUserId();
  }
}
