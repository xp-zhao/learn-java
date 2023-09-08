package org.example.queue.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
public class SeckillEventFactory implements EventFactory<SeckillEvent> {
  @Override
  public SeckillEvent newInstance() {
    return new SeckillEvent();
  }
}
