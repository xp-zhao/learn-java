package org.example.queue.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
public class DisruptorUtil {
  private static Disruptor<SeckillEvent> disruptor;

  static {
    SeckillEventFactory factory = new SeckillEventFactory();
    int ringBufferSize = 1024;
    ThreadFactory threadFactory = runnable -> new Thread(runnable);
    disruptor = new Disruptor<>(factory, ringBufferSize, threadFactory);
    disruptor.handleEventsWith(new SeckillEventConsumer());
    disruptor.start();
  }

  public static void producer(SeckillEvent seckillEvent) {
    RingBuffer<SeckillEvent> ringBuffer = disruptor.getRingBuffer();
    SeckillEventProducer producer = new SeckillEventProducer(ringBuffer);
    producer.seckill(seckillEvent.getSeckillId(), seckillEvent.getUserId());
  }
}
