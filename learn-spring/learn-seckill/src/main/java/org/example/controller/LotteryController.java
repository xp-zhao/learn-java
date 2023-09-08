package org.example.controller;

import jakarta.annotation.Resource;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.extern.slf4j.Slf4j;
import org.example.common.Result;
import org.example.entity.UserTakeSeckill;
import org.example.queue.disruptor.DisruptorUtil;
import org.example.queue.disruptor.SeckillEvent;
import org.example.queue.jvm.SeckillQueue;
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
      Result result = seckillService.startSeckillByAop(awardId, userId);
      log.info("用户:{}--{}", userId, result.getInfo());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }

  @PostMapping("/start/pes/lock/one")
  public Result startPesLockOne(long awardId) {
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      Result result = seckillService.startSeckillByUpdate(awardId, userId);
      log.info("用户:{}--{}", userId, result.getInfo());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }

  @PostMapping("/start/pes/lock/two")
  public Result startPesLockTwo(long awardId) {
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      Result result = seckillService.startSeckillByUpdateTwo(awardId, userId);
      log.info("用户:{}--{}", userId, result.getInfo());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }

  @PostMapping("/start/opt/lock")
  public Result startOptLock(long awardId) {
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      Result result = seckillService.startSecondKillByOptLock(awardId, userId, 1);
      log.info("用户:{}--{}", userId, result.getInfo());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }

  @PostMapping("/start/queue")
  public Result startQueue(long awardId) {
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      UserTakeSeckill seckill = new UserTakeSeckill();
      seckill.setAwardId(awardId);
      seckill.setUserId(userId);
      boolean flag = SeckillQueue.getQueue().produce(seckill);
      log.info("用户:{}--{}", userId, flag ? "秒杀队列入队成功" : "入队失败");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }

  @PostMapping("/start/disruptor")
  public Result startDisruptor(long awardId) {
    try {
      log.info("开始秒杀");
      final long userId = (int) (new Random().nextDouble() * (99999 - 10000 + 1)) + 10000;
      SeckillEvent kill = new SeckillEvent();
      kill.setSeckillId(awardId);
      kill.setUserId(userId);
      DisruptorUtil.producer(kill);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }
}
