package com.example.h2.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2024-4-22
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

  private static ApplicationContext applicationContext;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    SpringContextUtil.applicationContext = applicationContext;
  }

  /** 获取上下文 */
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
}
