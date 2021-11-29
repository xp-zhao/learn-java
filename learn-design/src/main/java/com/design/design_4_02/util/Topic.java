package com.design.design_4_02.util;

import java.util.Map;

public class Topic {

  /** 选项；A、B、C、D */
  private Map<String, String> option;
  /** 答案；B */
  private String key;

  public Topic() {}

  public Topic(Map<String, String> option, String key) {
    this.option = option;
    this.key = key;
  }

  public Map<String, String> getOption() {
    return option;
  }

  public void setOption(Map<String, String> option) {
    this.option = option;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
