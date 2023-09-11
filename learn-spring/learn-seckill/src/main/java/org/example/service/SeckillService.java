package org.example.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.RequiredArgsConstructor;
import org.example.aop.ServiceLock;
import org.example.common.Constants;
import org.example.common.Result;
import org.example.entity.Award;
import org.example.entity.Payment;
import org.example.entity.UserTakeSeckill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 秒杀服务
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@Service
@RequiredArgsConstructor
public class SeckillService {

  private final Lock lock = new ReentrantLock(true);
  private final AwardService awardService;
  private final PaymentService paymentService;
  private final UserTakeSeckillService userTakeSeckillService;

  /**
   * 删除秒杀售卖商品记录
   *
   * @param skgId 商品id
   */
  public void deleteSeckillGoodsId(long skgId) {}

  /**
   * 查询秒杀售卖商品
   *
   * @param skgId 商品id
   * @return
   */
  public Integer getSecondKillCount(long skgId) {
    return null;
  }

  /**
   * 开始秒杀 - 使用Transactional + Lock
   *
   * @param awardId 商品id
   * @param userId 用户id
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public Result startSeckillByLock(long awardId, long userId) {
    // 在这里加锁，可能会出现事务未提交之前，锁就已经释放了，这样下一个请求就能顺利获取到锁
    // 并发情况下就会出现用户秒杀记录大与商品数量的情况（前一个事务未提交，后一个事务中获取到的商品数量还是未修改的）
    // lock.lock();
    try {
      // 校验库存
      Award award = awardService.getById(awardId);
      Integer awardCount = Optional.ofNullable(award).map(Award::getAwardCount).orElse(0);
      if (awardCount > 0) {
        // 扣库存
        award.setAwardCount(awardCount - 1);
        awardService.updateById(award);
        // 创建秒杀记录
        UserTakeSeckill userTakeSeckill = new UserTakeSeckill();
        userTakeSeckill.setAwardId(awardId);
        userTakeSeckill.setUserId(userId);
        userTakeSeckill.setState(0);
        userTakeSeckill.setCreateTime(LocalDateTime.now());
        userTakeSeckill.setUpdateTime(LocalDateTime.now());
        userTakeSeckillService.save(userTakeSeckill);
        // 模拟支付
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAwardId(awardId);
        payment.setState(1);
        payment.setMoney(100L);
        payment.setCreateTime(LocalDateTime.now());
        paymentService.save(payment);
      } else {
        return Result.buildResult(Constants.ResponseCode.END);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //      lock.unlock();
    }
    return Result.buildSuccessResult();
  }

  /**
   * 开始秒杀 - 使用Aop
   *
   * @param awardId 商品id
   * @param userId 用户id
   * @return
   */
  @ServiceLock // 使用 aop 进行加锁
  @Transactional(rollbackFor = Exception.class)
  public Result startSeckillByAop(long awardId, long userId) {
    try {
      // 校验库存
      Award award = awardService.getById(awardId);
      Integer awardCount = Optional.ofNullable(award).map(Award::getAwardCount).orElse(0);
      if (awardCount > 0) {
        // 扣库存
        award.setAwardCount(awardCount - 1);
        awardService.updateById(award);
        // 创建秒杀记录
        UserTakeSeckill userTakeSeckill = new UserTakeSeckill();
        userTakeSeckill.setAwardId(awardId);
        userTakeSeckill.setUserId(userId);
        userTakeSeckill.setState(0);
        userTakeSeckill.setCreateTime(LocalDateTime.now());
        userTakeSeckill.setUpdateTime(LocalDateTime.now());
        userTakeSeckillService.save(userTakeSeckill);
        // 模拟支付
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAwardId(awardId);
        payment.setState(1);
        payment.setMoney(100L);
        payment.setCreateTime(LocalDateTime.now());
        paymentService.save(payment);
      } else {
        return Result.buildResult(Constants.ResponseCode.END);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildSuccessResult();
  }

  /**
   * 开始秒杀 - 数据库悲观锁<br>
   * 使用 for update 必须加上事务，当事务提交之后，for update 才会解除行级锁
   *
   * @param awardId 商品id
   * @param userId 用户id
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public Result startSeckillByUpdate(long awardId, long userId) {
    try {
      // 校验库存-悲观锁
      Award award = awardService.queryAwardForUpdate(awardId);
      Integer awardCount = Optional.ofNullable(award).map(Award::getAwardCount).orElse(0);
      if (awardCount > 0) {
        // 扣库存
        award.setAwardCount(awardCount - 1);
        awardService.updateById(award);
        // 创建秒杀记录
        UserTakeSeckill userTakeSeckill = new UserTakeSeckill();
        userTakeSeckill.setAwardId(awardId);
        userTakeSeckill.setUserId(userId);
        userTakeSeckill.setState(0);
        userTakeSeckill.setCreateTime(LocalDateTime.now());
        userTakeSeckill.setUpdateTime(LocalDateTime.now());
        userTakeSeckillService.save(userTakeSeckill);
        // 模拟支付
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAwardId(awardId);
        payment.setState(1);
        payment.setMoney(100L);
        payment.setCreateTime(LocalDateTime.now());
        paymentService.save(payment);
      } else {
        return Result.buildResult(Constants.ResponseCode.END);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildErrorResult();
  }

  /**
   * 开始秒杀 - 数据库悲观锁<br>
   * update 锁表
   *
   * @param 商品id
   * @param userId 用户id
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public Result startSeckillByUpdateTwo(long awardId, long userId) {
    try {
      // 直接扣减库存，看能否更新成功
      Integer result = awardService.updateAwardById(awardId);
      if (result > 0) {
        // 创建秒杀记录
        UserTakeSeckill userTakeSeckill = new UserTakeSeckill();
        userTakeSeckill.setAwardId(awardId);
        userTakeSeckill.setUserId(userId);
        userTakeSeckill.setState(0);
        userTakeSeckill.setCreateTime(LocalDateTime.now());
        userTakeSeckill.setUpdateTime(LocalDateTime.now());
        userTakeSeckillService.save(userTakeSeckill);
        // 模拟支付
        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setAwardId(awardId);
        payment.setState(1);
        payment.setMoney(100L);
        payment.setCreateTime(LocalDateTime.now());
        paymentService.save(payment);
      } else {
        return Result.buildResult(Constants.ResponseCode.END);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildErrorResult();
  }

  /**
   * 开始秒杀 - 数据库乐观锁
   *
   * @param awardId
   * @param userId
   * @param awardCount
   * @return
   */
  @Transactional(rollbackFor = Exception.class)
  public Result startSecondKillByOptLock(long awardId, long userId, int awardCount) {
    try {
      // 乐观锁，不进行库存校验，直接判断商品数量是否大于秒杀数据
      Award award = awardService.getById(awardId);
      if (award.getAwardCount() >= awardCount) {
        Integer result = awardService.updateAwardByVersion(awardId, awardCount, award.getVersion());
        if (result > 0) {
          // 创建秒杀记录
          UserTakeSeckill userTakeSeckill = new UserTakeSeckill();
          userTakeSeckill.setAwardId(awardId);
          userTakeSeckill.setUserId(userId);
          userTakeSeckill.setState(0);
          userTakeSeckill.setCreateTime(LocalDateTime.now());
          userTakeSeckill.setUpdateTime(LocalDateTime.now());
          userTakeSeckillService.save(userTakeSeckill);
          // 模拟支付
          Payment payment = new Payment();
          payment.setUserId(userId);
          payment.setAwardId(awardId);
          payment.setState(1);
          payment.setMoney(100L);
          payment.setCreateTime(LocalDateTime.now());
          paymentService.save(payment);
        }
      } else {
        return Result.buildResult(Constants.ResponseCode.END);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Result.buildErrorResult();
  }
}
