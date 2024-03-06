package com.spring.example01;

import lombok.Data;

/**
 * 请求参数对象
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Data
public class RequestParam {
  private String businessCode;
  private Integer businessType;
}
