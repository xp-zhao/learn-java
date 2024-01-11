package com.xp.state.v4.status.machine;

import com.xp.state.v4.status.Status;
import com.xp.state.v4.status.event.Event;

/**
 * 审核任务状态机
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public class ReviewTaskStatusMachine implements IStatusMachine {
  @Override
  public Status getNextStatus(Status status, Event event) {
    switch (status) {
      case TASK_SUBMIT:
        return Status.FIRST_REVIEWING;

      case FIRST_REVIEWING:
        return getFirstReviewStatus(event);
      case FIRST_REVIEW_PASS:
        return Status.THIRD_REVIEWING;
      case FIRST_REVIEW_FAIL:
        return Status.TASK_FAIL;
      case FIRST_REVIEW_MODIFY:
        return getFirstReviewStatus(event);

      case THIRD_REVIEWING:
        return getThirdReviewStatus(event);
      case THIRD_REVIEW_PASS:
        return Status.TASK_SUCCESS;
      case THIRD_REVIEW_FAIL:
        return Status.TASK_FAIL;
      case THIRD_REVIEW_MODIFY:
        return getThirdReviewStatus(event);

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

  private Status getThirdReviewStatus(Event event) {
    switch (event) {
      case PASS:
        return Status.THIRD_REVIEW_PASS;
      case FAIL:
        return Status.THIRD_REVIEW_FAIL;
      case MODIFY:
        return Status.THIRD_REVIEW_MODIFY;
      default:
        throw new RuntimeException("不支持该Event审批意见");
    }
  }
}
