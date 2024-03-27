package com.spring.example02;

import java.util.List;
import lombok.Data;

/**
 * 返回参数
 *
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
@Data
public class PageResult<T> {
  private Integer count;
  private List<T> result;
}
