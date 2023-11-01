package com.example.feature.register;

import com.example.feature.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
@Slf4j
@SpringBootTest(classes = Application.class)
public class OperationTest {
  @Autowired private AddOperation addOperation;
  @Autowired private SubOperation subOperation;

  @Test
  public void testAdd() {
    log.info("add: {}", addOperation.add(1, 2));
  }

  @Test
  public void testSub() {
    log.info("sub: {}", subOperation.sub(2, 1));
  }
}
