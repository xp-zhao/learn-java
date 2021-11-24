package com.xp.example;

import org.junit.Test;

/**
 * 使用示例
 *
 * @author zhaoxiaoping
 * @date 2021-11-24
 */
public class ExampleTest {
  @Test(expected = RuntimeException.class)
  public void testTrue() {
    CommonUtil.isTrue(true).throwMessage("错误信息");
  }

  @Test
  public void testFalse() {
    CommonUtil.isTrue(false).throwMessage("错误信息");
  }

  @Test
  public void testTrueOrFalse() {
    CommonUtil.isTrueOrFalse(false)
        .trueOrFalseHandle(() -> System.out.println("true"), () -> System.out.println("false"));
    CommonUtil.isTrueOrFalse(true)
        .trueOrFalseHandle(() -> System.out.println("true"), () -> System.out.println("false"));
  }

  @Test
  public void testBlankOrNotBlank() {
    CommonUtil.isBlankOrNotBlank("xxx")
        .presentOrElseHandle(System.out::println, () -> System.out.println("空字符串"));
    CommonUtil.isBlankOrNotBlank("")
        .presentOrElseHandle(System.out::println, () -> System.out.println("空字符串"));
  }
}
