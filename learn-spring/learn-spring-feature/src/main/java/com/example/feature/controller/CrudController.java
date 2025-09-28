package com.example.feature.controller;

import com.example.feature.controller.entity.UserEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaoxiaoping
 * @date 2025-09-28
 */
@RestController
@RequestMapping("/crud")
public class CrudController {

  private static final List<UserEntity> USER_ENTITY_LIST = new ArrayList<>();

  static {
    USER_ENTITY_LIST.add(new UserEntity("1", "张三"));
    USER_ENTITY_LIST.add(new UserEntity("2", "李四"));
    USER_ENTITY_LIST.add(new UserEntity("3", "王五"));
  }

  @GetMapping("/list")
  public List<UserEntity> list() {
    return USER_ENTITY_LIST;
  }

  @GetMapping("/query/{userId}")
  public UserEntity query(@PathVariable("userId") String userId) {
    return USER_ENTITY_LIST.stream()
        .filter(item -> item.getUserId().equals(userId))
        .findFirst()
        .orElse(null);
  }

  @PostMapping("/save")
  public void save(@RequestBody UserEntity userEntity) {
    USER_ENTITY_LIST.add(userEntity);
  }

  @PostMapping("/delete")
  public void delete(String userId) {
    USER_ENTITY_LIST.removeIf(item -> item.getUserId().equals(userId));
  }
}
