package com.xp.state.v4.status.machine;

import com.xp.state.v4.status.Status;
import com.xp.state.v4.status.event.Event;

/**
 * 制作任务状态机
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public class MakeTaskStatusMachine implements IStatusMachine {
  @Override
  public Status getNextStatus(Status status, Event event) {
    switch (status) {
      case TASK_SUBMIT:
        // 任务提交后直接变成审核中
        return Status.FIRST_REVIEWING;

      case FIRST_REVIEWING:
        // 审核中需要审批意见 审批意见不用返回不同的状态
        return getFirstReviewStatus(event);
      case FIRST_REVIEW_PASS:
        // 一级审核通过，则跳转二级审核
        return Status.SECOND_REVIEWING;
      case FIRST_REVIEW_FAIL:
        // 一级审核不通过，任务失败
        return Status.TASK_FAIL;
      case FIRST_REVIEW_MODIFY:
        return getFirstReviewStatus(event);

      case SECOND_REVIEWING:
        return getSecondReviewStatus(event);
      case SECOND_REVIEW_PASS:
        return Status.TASK_SUCCESS;
      case SECOND_REVIEW_FAIL:
        return Status.TASK_FAIL;
      case SECOND_REVIEW_MODIFY:
        return getSecondReviewStatus(event);

      default:
        throw new RuntimeException("没有该流程");
    }
  }

  private Status getFirstReviewStatus(Event event) {
    switch (event) {
      case PASS:
        // 审核通过
        return Status.FIRST_REVIEW_PASS;
      case FAIL:
        // 审核不通过
        return Status.FIRST_REVIEW_FAIL;
      case MODIFY:
        return Status.FIRST_REVIEW_MODIFY;
      default:
        throw new RuntimeException("不支持该Event审批意见");
    }
  }

  private Status getSecondReviewStatus(Event event) {
    switch (event) {
      case PASS:
        return Status.SECOND_REVIEW_PASS;
      case FAIL:
        return Status.SECOND_REVIEW_FAIL;
      case MODIFY:
        return Status.SECOND_REVIEW_MODIFY;
      default:
        throw new RuntimeException("不支持该Event审批意见");
    }
  }
}
