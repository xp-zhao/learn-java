package org.learn.flowable.listener;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.api.delegate.event.FlowableEvent;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.engine.delegate.event.FlowableProcessStartedEvent;
import org.springframework.stereotype.Component;

/**
 * 流程监听器
 *
 * @author zhaoxiaoping
 * @date 2024-6-25
 */
@Slf4j
@Component
public class ProcessLifecycleListener implements FlowableEventListener {
  @Override
  public void onEvent(FlowableEvent flowableEvent) {
    if (flowableEvent instanceof FlowableProcessStartedEvent) {
      log.info("流程启动");
    }
  }

  @Override
  public boolean isFailOnException() {
    return false;
  }

  @Override
  public boolean isFireOnTransactionLifecycleEvent() {
    return false;
  }

  @Override
  public String getOnTransaction() {
    return "";
  }
}
