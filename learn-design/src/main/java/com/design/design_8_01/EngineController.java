package com.design.design_8_01;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class EngineController {
  public String process(final String userId, final String userSex, final int userAge) {

    log.info("if else实现方式判断用户结果。userId：{} userSex：{} userAge：{}", userId, userSex, userAge);
    if ("man".equals(userSex)) {
      if (userAge < 25) {
        return "果实A";
      }
      if (userAge >= 25) {
        return "果实B";
      }
    }
    if ("woman".equals(userSex)) {
      if (userAge < 25) {
        return "果实C";
      }
      if (userAge >= 25) {
        return "果实D";
      }
    }
    return null;
  }
}
