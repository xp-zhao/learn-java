package org.learn.flowable.controller.response;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用返回对象
 *
 * @author zhaoxiaoping
 * @date 2024-6-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResp {

  /** 标题头 */
  private List<Header> headerList;

  /** 数据值 */
  private List<Map<String, String>> valueList;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Header {
    /** 标题 key */
    private String key;

    /** 标题 title */
    private String title;

    /** 类型 */
    private String type;
  }
}
