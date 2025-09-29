package com.example.feature.controller.entity;

import java.util.List;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2025-09-29
 */
@Data
public class PageResult {
  private PageData data;
  private String msg;
  private Integer status;

  @Data
  public static class PageData {
    private Integer count;
    private List<UserEntity> rows;
  }
}
