package com.xp.state.v4.status.event;

/**
 * 事件枚举
 *
 * @author zhaoxiaoping
 * @date 2024-1-10
 */
public enum Event {
  PASS("pass", "通过"),
  FAIL("fail", "不通过"),
  MODIFY("modify", "修改");

  private String code;
  private String desc;

  private Event(String code, String desc) {
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
