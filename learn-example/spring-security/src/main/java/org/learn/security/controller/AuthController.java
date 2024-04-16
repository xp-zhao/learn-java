package org.learn.security.controller;

import cn.hutool.jwt.JWT;
import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import org.learn.security.controller.request.SignInReq;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @PostMapping("/login")
  public String login(@RequestBody SignInReq req) {

    UsernamePasswordAuthenticationToken authenticationToken =
        new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword());
    authenticationManager.authenticate(authenticationToken);

    //上一步没有抛出异常说明认证成功，我们向用户颁发jwt令牌
    String token = JWT.create()
        .setPayload("username", req.getUsername())
        .setKey("key".getBytes(StandardCharsets.UTF_8))
        .sign();

    return token;
  }
}
