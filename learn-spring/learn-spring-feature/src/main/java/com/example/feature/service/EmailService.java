package com.example.feature.service;

import com.example.feature.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @author xp-zhao
 * @description 邮件服务
 * @date 2022/9/23 22:02
 */
@Slf4j
@Service
public class EmailService implements ApplicationListener<UserRegisterEvent> {

  @Override
  public void onApplicationEvent(UserRegisterEvent event) {
    log.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUserName());
  }
}
