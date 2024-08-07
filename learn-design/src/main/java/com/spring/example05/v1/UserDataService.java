package com.spring.example05.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户数据处理流程服务
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Slf4j
@Service
public class UserDataService extends ProcessTemplate {
  public UserDataService(DataHandleService dataHandleService) {
    super(dataHandleService);
  }

  @Override
  protected void beforeHandle() {
    log.info("用户数据初始化");
  }

  @Override
  protected void specialHandle() {
    log.info("用户数据特殊处理");
  }
}
