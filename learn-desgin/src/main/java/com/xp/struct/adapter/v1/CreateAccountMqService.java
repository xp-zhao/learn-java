package com.xp.struct.adapter.v1;

import com.alibaba.fastjson.JSON;
import com.xp.struct.adapter.common.mq.CreateAccount;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 创建用户消息处理服务
 * @Date 2021-4-30
 **/
@Slf4j
public class CreateAccountMqService {

  public void onMessage(String message) {

    CreateAccount mq = JSON.parseObject(message, CreateAccount.class);

    log.info(mq.getNumber());
    log.info(mq.getAccountDate().toString());

    // ... 处理自己的业务
  }
}
