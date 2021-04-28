package com.xp.executor.v1;

import java.net.URLEncoder;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 规则数据
 * @Date 2021-4-25
 **/
@Data
public class RuleDto {

  private String address;
  private Integer age;

  public static void main(String[] args) {
    System.out.println(URLEncoder.encode("中午"));
    System.out.println("中午");
  }
}
