package com.example.mp.controller;

import com.example.mp.entity.User;
import com.example.mp.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoxiaoping
 * @date 2022-11-9
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Resource private UserService userService;

  @PostMapping("/save")
  @Transactional(rollbackFor = Exception.class)
  public boolean save() {
    User user = new User();
    user.setId(6L);
    user.setName("xxx");
    user.setAge(0);
    user.setEmail("xxx");
    List<User> list = userService.list();
    System.out.println("before: " + list.size());
    boolean save = userService.save(user);
    list = userService.list();
    System.out.println("after: " + list.size());
    int i = 1 / 0;
    return save;
  }
}
