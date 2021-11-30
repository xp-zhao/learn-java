package com.design.design_17_00;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
public class ConfigOriginator {
  private ConfigFile configFile;

  public ConfigMemento saveMemento() {
    return new ConfigMemento(configFile);
  }

  public void getMemento(ConfigMemento memento) {
    this.configFile = memento.getConfigFile();
  }
}
