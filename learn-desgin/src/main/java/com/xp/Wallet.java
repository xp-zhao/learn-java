package com.xp;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author zhaoxiaoping
 * @Description: 钱包
 * @Date 2020-10-20
 **/
public class Wallet {

  private String id;
  private long createTime;
  private BigDecimal balance;
  private long balanceLastModifiedTime;

  public Wallet() {
    this.id = UUID.randomUUID().toString();
    this.createTime = System.currentTimeMillis();
    this.balance = BigDecimal.ZERO;
    this.balanceLastModifiedTime = System.currentTimeMillis();
  }

  public String getId() {
    return id;
  }

  public long getCreateTime() {
    return createTime;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public long getBalanceLastModifiedTime() {
    return balanceLastModifiedTime;
  }

  public void increaseBalance(BigDecimal increasedAmount) {
    if (increasedAmount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("参数错误");
    }
    this.balance.add(increasedAmount);
    this.balanceLastModifiedTime = System.currentTimeMillis();
  }

  public void decreaseBalance(BigDecimal decreasedAmount) {
    if (decreasedAmount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("参数错误");
    }
    if (decreasedAmount.compareTo(balance) > 0) {
      throw new IllegalArgumentException("余额不足");
    }
    this.balance.subtract(decreasedAmount);
    this.balanceLastModifiedTime = System.currentTimeMillis();
  }
}
