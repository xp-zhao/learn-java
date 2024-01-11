package com.xp.state.v4.status.make.first;

import com.xp.state.v4.Task;
import com.xp.state.v4.status.handle.AbstractStatusHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 一级审核-打回修改
 *
 * @author zhaoxiaoping
 * @date 2024-1-11
 */
@Slf4j
public class FirstReviewModifyStatusHandler extends AbstractStatusHandler {
  @Override
  protected void doHandler(Task task) {
    log.info("user:{}--一级审核打回修改 task-tatus:{}", task.getUser(), task.getStatus().getCode());
  }
}
