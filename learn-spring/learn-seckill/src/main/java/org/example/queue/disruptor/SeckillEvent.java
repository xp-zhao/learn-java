package org.example.queue.disruptor;

import java.io.Serializable;

/**
 * 秒杀事件对象
 *
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
public class SeckillEvent implements Serializable {
  private static final long serialVersionUID = 1L;
  private long seckillId;
  private long userId;

  public SeckillEvent() {}

  public long getSeckillId() {
    return seckillId;
  }

  public void setSeckillId(long seckillId) {
    this.seckillId = seckillId;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }
}
