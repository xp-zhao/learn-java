package com.xp.state.v4;

import com.xp.state.v4.common.TaskType;
import com.xp.state.v4.status.Status;
import com.xp.state.v4.status.event.Event;
import lombok.Data;

/**
 * 任务对象
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
@Data
public class Task {
  private Status status;
  private TaskType taskType;
  private Event event;
  private String user;
}
