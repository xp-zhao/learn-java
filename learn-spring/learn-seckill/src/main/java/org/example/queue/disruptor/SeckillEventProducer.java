package org.example.queue.disruptor;

import com.lmax.disruptor.EventTranslatorVararg;
import com.lmax.disruptor.RingBuffer;

/**
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
public class SeckillEventProducer {
  private static final EventTranslatorVararg<SeckillEvent> translator =
      (seckillEvent, seq, objs) -> {
        seckillEvent.setSeckillId((Long) objs[0]);
        seckillEvent.setUserId((Long) objs[1]);
      };

  private final RingBuffer<SeckillEvent> ringBuffer;

  public SeckillEventProducer(RingBuffer<SeckillEvent> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void seckill(long seckillId, long userId) {
    this.ringBuffer.publishEvent(translator, seckillId, userId);
  }
}
