package com.design.design_17_00;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 配置文件
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
@AllArgsConstructor
public class ConfigFile {
  /** 版本号 */
  private String versionNo;
  /** 内容 */
  private String content;
  /** 时间 */
  private Date dateTime;
  /** 操作人 */
  private String operator;
}
