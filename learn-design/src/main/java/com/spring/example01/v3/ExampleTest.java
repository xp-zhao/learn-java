package com.spring.example01.v3;

import com.spring.example01.RequestParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Slf4j
public class ExampleTest {
  @Test
  public void testBuild() throws IllegalAccessException {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    ExpressionService service =
        applicationContext.getBean("expressionService", ExpressionService.class);
    RequestParam param = service.buildParam("Alipay", "1001");
    log.info("请求参数：{}", param);
  }
}
