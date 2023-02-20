package org.learn.spring.v7;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.context.support.ClassPathXmlApplicationContext;
import org.learn.spring.v7.bean.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-20
 */
@Slf4j
public class ApiTest {
  @Test
  public void test_xml() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring-v7.xml");
    applicationContext.registerShutdownHook();
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    log.info("测试结果: {}", result);
  }

  @Test
  public void test_hook() {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
  }

  @Test
  public void test_map_remove() {
    Map<String, String> map = new HashMap<>();
    map.put("1", "1");
    map.put("2", "2");
    map.put("3", "3");
    Set<String> keySet = map.keySet();
//    for (String key : keySet) {
//      String value = map.remove(key);
//      System.out.println(value);
//    }
    for (Object key : keySet.toArray()) {
      String value = map.remove(key);
      System.out.println(value);
    }
  }
}
