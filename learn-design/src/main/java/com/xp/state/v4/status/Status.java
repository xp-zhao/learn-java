package com.xp.state.v4.status;

/**
 * 任务状态枚举
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public enum Status {
  /** 提交任务 */
  TASK_SUBMIT("taskSubmit", "提交任务"),
  /** 一级审核 */
  FIRST_REVIEWING("firstReviewing", "一级审核中"),
  FIRST_REVIEW_PASS("firstReviewPass", "一级审核通过"),
  FIRST_REVIEW_FAIL("firstReviewFail", "一级审核不通过"),
  FIRST_REVIEW_MODIFY("firstReviewModify", "一级审核打回修改"),

  /** 二级审核 */
  SECOND_REVIEWING("secondReviewing", "二级审核中"),
  SECOND_REVIEW_PASS("secondReviewPass", "二级审核通过"),
  SECOND_REVIEW_FAIL("secondReviewFail", "二级审核不通过"),
  SECOND_REVIEW_MODIFY("secondReviewModify", "二级审核打回修改"),
  /** 三级审核 */
  THIRD_REVIEWING("thirdReviewing", "三级审核中"),
  THIRD_REVIEW_PASS("thirdReviewPass", "三级审核通过"),
  THIRD_REVIEW_FAIL("thirdReviewFail", "三级审核不通过"),
  THIRD_REVIEW_MODIFY("thirdReviewModify", "三级审核打回修改"),

  /** 任务最终状态 */
  TASK_SUCCESS("taskSuccess", "任务成功"),
  TASK_FAIL("taskFail", "任务失败");

  private String code;
  private String desc;

  Status(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String status) {
    this.code = status;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
