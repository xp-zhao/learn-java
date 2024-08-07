package com.spring.example05.v2.context;

import com.spring.example05.v2.common.ResultEnum;
import java.io.Serializable;
import java.util.Map;
import lombok.Data;

/**
 * 基础流程上下文对象
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Data
public class BaseProcessContext implements Serializable {
  /** 拓展信息 */
  private Map<String, String> extInfo;

  /** 处理结果 */
  private ResultEnum result;
}
