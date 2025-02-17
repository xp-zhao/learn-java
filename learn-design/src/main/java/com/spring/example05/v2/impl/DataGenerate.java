package com.spring.example05.v2.impl;

import com.spring.example05.v2.AbstractTaskIdempotent;
import com.spring.example05.v2.common.ResultEnum;
import com.spring.example05.v2.common.TaskConfig;
import com.spring.example05.v2.context.UserDataContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 数据制作
 *
 * @author zhaoxiaoping
 * @date 2024-8-7
 */
@Slf4j
@RequiredArgsConstructor
@TaskConfig(name = "dataGenerate")
public class DataGenerate extends AbstractTaskIdempotent<UserDataContext> {
  @Override
  protected UserDataContext executeBusinessLogic(UserDataContext context) {
    log.info("用户信息初始化");
    return context.ofResult(ResultEnum.SUCCESS);
  }
}
