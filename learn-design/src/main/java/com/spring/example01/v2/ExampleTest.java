package com.spring.example01.v2;

import com.spring.example01.RequestParam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用策略模式优化
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Slf4j
public class ExampleTest {
  @Test
  public void testBuild() {
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    StrategyClient client = applicationContext.getBean("strategyClient", StrategyClient.class);
    RequestParam param = client.buildParam("Alipay", "1001");
    log.info("请求参数：{}", param);
  }
}
