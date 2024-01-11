package com.xp.state.v4;

import com.xp.state.v4.common.TaskType;
import com.xp.state.v4.engine.StatusMachineEngine;
import com.xp.state.v4.status.Status;
import com.xp.state.v4.status.event.Event;
import com.xp.state.v4.status.handle.TaskHandler;
import com.xp.state.v4.status.make.MakeTaskFailStatusHandler;
import com.xp.state.v4.status.make.MakeTaskPassStatusHandler;
import com.xp.state.v4.status.make.MakeTaskSubmitStatusHandler;
import com.xp.state.v4.status.make.first.FirstReviewFailStatusHandler;
import com.xp.state.v4.status.make.first.FirstReviewModifyStatusHandler;
import com.xp.state.v4.status.make.first.FirstReviewPassStatusHandler;
import com.xp.state.v4.status.make.first.FirstReviewingStatusHandler;
import com.xp.state.v4.status.make.second.SecondReviewFailStatusHandler;
import com.xp.state.v4.status.make.second.SecondReviewModifyStatusHandler;
import com.xp.state.v4.status.make.second.SecondReviewPassStatusHandler;
import com.xp.state.v4.status.make.second.SecondReviewingStatusHandler;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2024-1-11
 */
public class Client {

  public static void main(String[] args) {
    // 注册制作任务的状态和对应状态的处理类StatusHandler
    registryMakeTaskStatusHandler();

    TaskHandler taskHandler = new TaskHandler();
    // 状态机引擎接受事件处理类
    StatusMachineEngine.addListener(taskHandler);
    // 生成任务
    Task task = new Task();
    task.setTaskType(TaskType.MAKE_TASK);
    task.setStatus(Status.TASK_SUBMIT);
    task.setUser("test");
    // 交给引擎去执行
    StatusMachineEngine.post(task);

    task.setEvent(Event.PASS);
    StatusMachineEngine.post(task);
    task.setEvent(Event.PASS);
    StatusMachineEngine.post(task);
  }

  public static void registryMakeTaskStatusHandler() {

    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.TASK_SUBMIT, new MakeTaskSubmitStatusHandler());

    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.FIRST_REVIEW_PASS, new FirstReviewPassStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.FIRST_REVIEW_FAIL, new FirstReviewFailStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.FIRST_REVIEW_MODIFY, new FirstReviewModifyStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.FIRST_REVIEWING, new FirstReviewingStatusHandler());

    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.SECOND_REVIEW_PASS, new SecondReviewPassStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.SECOND_REVIEW_FAIL, new SecondReviewFailStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.SECOND_REVIEW_MODIFY, new SecondReviewModifyStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.SECOND_REVIEWING, new SecondReviewingStatusHandler());

    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.TASK_SUCCESS, new MakeTaskPassStatusHandler());
    StatusHandlerRegistry.registryStatusHandler(
        TaskType.MAKE_TASK, Status.TASK_FAIL, new MakeTaskFailStatusHandler());
  }
}
