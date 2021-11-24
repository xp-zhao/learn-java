package com.xp.example;

import cn.hutool.core.util.StrUtil;

/**
 * 通用工具类
 *
 * @author zhaoxiaoping
 * @date 2021-11-24
 */
public abstract class CommonUtil {
  /**
   * 如果参数为 true 就抛出异常
   *
   * @param condition 条件
   * @return {@code ThrowExceptionFunction}
   */
  public static ThrowExceptionFunction isTrue(boolean condition) {
    return (errorMessage) -> {
      if (condition) {
        throw new RuntimeException(errorMessage);
      }
    };
  }

  /**
   * 参数为 true 和 false 时执行对应的操作
   *
   * @param condition 条件
   * @return {@code BranchHandle}
   */
  public static BranchHandle isTrueOrFalse(boolean condition) {
    return ((trueHandle, falseHandle) -> {
      if (condition) {
        trueHandle.run();
      } else {
        falseHandle.run();
      }
    });
  }

  /**
   * 字符串空和非空时做不同操作
   *
   * @param str str
   * @return {@code PresentOrElseHandler<?>}
   */
  public static PresentOrElseHandler<?> isBlankOrNotBlank(String str) {
    return (consumer, runnable) -> {
      if (StrUtil.isBlank(str)) {
        runnable.run();
      } else {
        consumer.accept(str);
      }
    };
  }
}
