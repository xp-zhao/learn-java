package com.xp.test;

import java.util.Arrays;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: lombok 日志打印测试
 * @Date 2020/4/15
 **/
@Slf4j
public class LogTest {

  public static void main(String[] args) {
    String str = "";
    String[] arrays = {"", ""};
    String[] s = str.split("-");
    String[] result = s.length > 1 ? s : arrays;
    System.out.println(result);
    log.info("log test");
    log.info("log test: {}", 12);
  }
}
