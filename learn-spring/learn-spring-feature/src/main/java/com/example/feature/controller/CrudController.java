package com.example.feature.controller;

import com.example.feature.controller.entity.PageResult;
import com.example.feature.controller.entity.UserEntity;
import java.util.ArrayList;
import java.util.Comparator;
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
    USER_ENTITY_LIST.add(new UserEntity("4", "四"));
    USER_ENTITY_LIST.add(new UserEntity("5", "五"));
    USER_ENTITY_LIST.add(new UserEntity("6", "六"));
    USER_ENTITY_LIST.add(new UserEntity("7", "七"));
  }

  @GetMapping("/list")
  public List<UserEntity> list() {
    return USER_ENTITY_LIST;
  }

  @GetMapping("/page")
  public PageResult page(
      @RequestParam(value = "page", defaultValue = "1") Integer page,
      @RequestParam(value = "perPage", defaultValue = "10") Integer perPage) {
    PageResult result = new PageResult();
    PageResult.PageData pageData = new PageResult.PageData();
    pageData.setCount(USER_ENTITY_LIST.size());
    pageData.setRows(USER_ENTITY_LIST);
    result.setData(pageData);
    result.setMsg("success");
    result.setStatus(0);
    return result;
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
    USER_ENTITY_LIST.removeIf(item -> item.getUserId().equals(userEntity.getUserId()));
    USER_ENTITY_LIST.add(userEntity);
    USER_ENTITY_LIST.sort(Comparator.comparing(UserEntity::getUserId));
  }

  @PostMapping("/delete/{userIds}")
  public void delete(@PathVariable("userIds") List<String> userIds) {
    USER_ENTITY_LIST.removeIf(item -> userIds.contains(item.getUserId()));
  }
}
