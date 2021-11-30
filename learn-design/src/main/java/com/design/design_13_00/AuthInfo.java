package com.design.design_13_00;

import lombok.Data;

/**
 * 审核信息
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
public class AuthInfo {
  private String code;
  private String info = "";

  public AuthInfo(String code, String... infos) {
    this.code = code;
    for (String str : infos) {
      this.info = this.info.concat(str);
    }
  }
}
