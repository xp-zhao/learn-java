package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.learn.cloud.Application;
import org.learn.cloud.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhaoxiaoping
 * @date 2024-5-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApiTest {
  @Autowired private TestService testService;

  @Test
  public void testQuery() {
    testService.query();
  }
}
