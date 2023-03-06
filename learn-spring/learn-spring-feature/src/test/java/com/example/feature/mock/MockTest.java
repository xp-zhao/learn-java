package com.example.feature.mock;

import com.example.feature.Application;
import com.example.feature.mock.bean.MockUser;
import com.example.feature.mock.bean.MockUserDao;
import com.example.feature.mock.bean.MockUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * mock 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-6
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class MockTest {
  @Autowired private MockUserService userService;
  @MockBean private MockUserDao userDao;

  @Test
  public void testQueryUserId() {
    MockUser user = userService.queryUserById("10001");
    log.info("用户信息: {}", user);
  }

  @Test
  public void testMock() {
    // 定义当调用 userDao.queryUserById() 方法, 并且参数为 1001 时, 返回 MockUser("1001", "1001") 对象
    Mockito.when(userDao.queryUserById("1001")).thenReturn(new MockUser("1001", "1001"));
    MockUser user = userService.queryUserById("1001");
    log.info("mock 结果: {}", user);
  }
}
