package com.design.design_6_01;

import com.alibaba.fastjson.JSON;
import com.design.design_6_00.mq.CreateAccount;
import lombok.extern.slf4j.Slf4j;

/**
 * 开户消息处理
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class CreateAccountMqService {
  public void onMessage(String message) {

    CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

    mq.getNumber();
    mq.getAccountDate();

    log.info("开户消息处理");
  }
}
