package org.example.controller;

import jakarta.annotation.Resource;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import org.example.common.Result;
import org.example.service.SeckillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 抽奖控制层
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@Slf4j
@RestController
@RequestMapping("/lottery")
public class LotteryController {

  private final Lock lock = new ReentrantLock(true);

  @Resource private SeckillService seckillService;

  @PostMapping("/start/lock")
  public Result startLock(long awardId) {
    // 在调用秒杀服务之前加锁，避免出现秒杀/支付记录大与商品数量的情况
    lock.lock();
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      Result result = seckillService.startSeckillByLock(awardId, userId);
      log.info("用户:{}--{}", userId, result.getInfo());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
    return Result.buildSuccessResult();
  }

  @PostMapping("/start/aop")
  public Result startAop(long awardId) {
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      Result result = seckillService.startSecondKillByAop(awardId, userId);
      log.info("用户:{}--{}", userId, result.getInfo());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }
}
