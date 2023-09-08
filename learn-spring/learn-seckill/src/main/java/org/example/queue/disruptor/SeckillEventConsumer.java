package org.example.queue.disruptor;

import com.lmax.disruptor.EventHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.common.Result;
import org.example.service.SeckillService;
import org.springframework.stereotype.Service;

/**
 * 秒杀事件消费者
 *
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
@Slf4j
@Service
public class SeckillEventConsumer implements EventHandler<SeckillEvent> {
  @Resource private SeckillService seckillService;

  @Override
  public void onEvent(SeckillEvent seckillEvent, long l, boolean b) throws Exception {
    Result result =
        seckillService.startSeckillByAop(seckillEvent.getSeckillId(), seckillEvent.getUserId());
    if (result.getCode().equals(Result.buildSuccessResult().getCode())) {
      log.info("用户:{}{}", seckillEvent.getUserId(), "秒杀成功");
    }
  }
}
