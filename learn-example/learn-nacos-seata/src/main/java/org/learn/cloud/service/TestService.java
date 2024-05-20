package org.learn.cloud.service;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-5-17
 */
@Service
public class TestService {

  @GlobalTransactional(rollbackFor = Exception.class)
  public void query() {
    System.out.println("success");
    return;
  }
}
