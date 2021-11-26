package com.xp.ChainOfResponsibility.v3;

import com.xp.ChainOfResponsibility.v2.Handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/2 10:44 下午 */
public class HandlerChain {
  private List<Handler> handlers = new ArrayList<>();

  public void addHandler(Handler handler) {
    this.handlers.add(handler);
  }

  public void handle() {
    // 将责任链列表乱序
    Collections.shuffle(handlers);
    for (Handler handler : handlers) {
      if (handler.doHandle()) {
        break;
      }
    }
  }
}
