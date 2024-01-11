package com.xp.state.v4.status.make.second;

import com.xp.state.v4.Task;
import com.xp.state.v4.status.handle.AbstractStatusHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * 二级审核未通过
 *
 * @author zhaoxiaoping
 * @date 2024-1-11
 */
@Slf4j
public class SecondReviewFailStatusHandler extends AbstractStatusHandler {
  @Override
  protected void doHandler(Task task) {
    log.info("user:{}二级审核未通过 task-status:{}", task.getUser(), task.getStatus().getCode());
  }
}
