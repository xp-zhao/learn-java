package com.spring.example05.v2.context;

import com.spring.example05.v2.common.ResultEnum;
import lombok.Data;

/**
 * 用户数据上下文
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Data
public class UserDataContext extends BaseProcessContext {
  /** 用户 id */
  private String userId;

  public UserDataContext ofResult(ResultEnum result) {
    super.setResult(result);
    return this;
  }
}
