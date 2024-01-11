package com.xp.state.v4.common;

/**
 * 任务类型
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public enum TaskType {
  MAKE_TASK("make_task", "制作任务"),
  REVIEW_TASK("review_task", "审核任务"),
  ;

  private String code;
  private String desc;

  private TaskType(String code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
