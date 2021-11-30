package com.design.design_17_00;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 配置文件备忘录
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
@AllArgsConstructor
public class ConfigMemento {
  private ConfigFile configFile;
}
