package org.learn.security.controller;

import cn.hutool.jwt.JWT;
import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import org.learn.security.controller.request.SignInReq;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaoxiaoping
 * @date 2024/4/16
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

  @Resource private AuthenticationManager authenticationManager;

  @GetMapping("/sayHi")
  public String sayHi() {
    return "hello security";
  }

  @PostMapping("/register")
  public String register() {
    return "注册成功";
  }

  @PostMapping("/login")
  public String login(@RequestBody SignInReq req) {

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
    authenticationManager.authenticate(authenticationToken);

    // 上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
    String token =
        JWT.create()
            .setPayload("username", req.getUsername())
            .setKey("key".getBytes(StandardCharsets.UTF_8))
            .sign();

    return token;
  }

  @PreAuthorize("hasRole('admin')")
  @GetMapping("/users/{id}")
  public String getUserDetail(@PathVariable String id) {
    return "用户详情:" + id;
  }
}
