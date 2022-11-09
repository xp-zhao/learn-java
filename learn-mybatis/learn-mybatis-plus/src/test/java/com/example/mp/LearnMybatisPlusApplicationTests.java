package com.example.mp;

import com.example.mp.entity.User;
import com.example.mp.mapper.UserMapper;
import com.example.mp.service.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class LearnMybatisPlusApplicationTests {

  @Resource private UserMapper userMapper;
  @Resource private UserService userService;

  @Test
  public void testSelect() {
    System.out.println(("----- selectAll method test ------"));
    List<User> userList = userMapper.selectList(null);
    Assertions.assertEquals(5, userList.size());
    userList.forEach(System.out::println);
  }
  
  @Test
  public void testService(){
    List<User> list = userService.list();
    System.out.println(list);
    User user = new User();
    user.setId(6L);
    user.setName("xxx");
    user.setAge(0);
    user.setEmail("xxx");
    userService.save(user);
    System.out.println(user);
    list = userService.list();
    System.out.println(list);
  }
}
