package util;

import java.util.UUID;

/**
 * @description: 用户 id 生成工具类
 * @author: zhaoxiaoping
 * @create: 2019/06/18
 **/
public class IDUtil {

  public static String randomId() {
    return UUID.randomUUID().toString().split("-")[0];
  }
}