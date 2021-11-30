package com.design.design_17_00;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class Admin {
  private int cursorIdx = 0;
  private List<ConfigMemento> mementoList = new ArrayList<ConfigMemento>();
  private Map<String, ConfigMemento> mementoMap = new ConcurrentHashMap<String, ConfigMemento>();

  public void append(ConfigMemento memento) {
    mementoList.add(memento);
    mementoMap.put(memento.getConfigFile().getVersionNo(), memento);
    cursorIdx++;
  }

  public ConfigMemento undo() {
    if (--cursorIdx <= 0) {
      return mementoList.get(0);
    }
    return mementoList.get(cursorIdx);
  }

  public ConfigMemento redo() {
    if (++cursorIdx > mementoList.size()) {
      return mementoList.get(mementoList.size() - 1);
    }
    return mementoList.get(cursorIdx);
  }

  public ConfigMemento get(String versionNo) {
    return mementoMap.get(versionNo);
  }
}
