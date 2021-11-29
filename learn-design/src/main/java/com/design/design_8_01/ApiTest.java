package com.design.design_8_01;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class ApiTest {
  @Test
  public void testEngineController() {
    EngineController engineController = new EngineController();
    String process = engineController.process("Oli09pLkdjh", "man", 29);
    log.info("测试结果：{}", process);
  }
}
