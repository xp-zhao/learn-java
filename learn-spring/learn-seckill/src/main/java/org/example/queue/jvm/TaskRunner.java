package org.example.queue.jvm;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.common.Result;
import org.example.entity.UserTakeSeckill;
import org.example.service.SeckillService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 消费秒杀队列
 *
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
@Slf4j
@Component
public class TaskRunner implements ApplicationRunner {

  @Resource private SeckillService seckillService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    new Thread(
            () -> {
              log.info("秒杀队列消费任务启动");
              while (true) {
                try {
                  UserTakeSeckill seckill = SeckillQueue.getQueue().consume();
                  if (seckill != null) {
                    Result result =
                        seckillService.startSeckillByAop(seckill.getAwardId(), seckill.getUserId());
                    if (result != null
                        && result.getCode().equals(Result.buildSuccessResult().getCode())) {
                      log.info("TaskRunner,result:{}", result);
                      log.info("TaskRunner从消息队列取出用户，用户:{}{}", seckill.getUserId(), "秒杀成功");
                    }
                  }
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            })
        .start();
  }
}
