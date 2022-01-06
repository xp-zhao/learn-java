package org.learn.spring.beans.factory.event;

import java.time.LocalDate;
import org.learn.spring.context.ApplicationListener;

/**
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {

  @Override
  public void onApplicationEvent(CustomEvent event) {
    System.out.println("收到：" + event.getSource() + "消息;时间：" + LocalDate.now());
    System.out.println("消息：" + event.getId() + ":" + event.getMessage());
  }
}
