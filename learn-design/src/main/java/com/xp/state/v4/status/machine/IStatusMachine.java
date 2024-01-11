package com.xp.state.v4.status.machine;

import com.xp.state.v4.status.Status;
import com.xp.state.v4.status.event.Event;

/**
 * 状态机接口
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public interface IStatusMachine {
  Status getNextStatus(Status status, Event event);
}
