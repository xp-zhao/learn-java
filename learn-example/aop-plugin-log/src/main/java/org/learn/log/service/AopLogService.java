package org.learn.log.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-4-16
 */
@Slf4j
@Service
public class AopLogService implements BeanNameAware, BeanFactoryAware {

  private BeanFactory beanFactory;
  private String beanName;

  @SneakyThrows
  public String sayHi(String message) {
    Object bean = beanFactory.getBean(beanName);
    log.info("{} is Advised: {}", bean, bean instanceof Advised);
    TimeUnit.SECONDS.sleep(new Random().nextInt(3));
    log.info("hi: {}", message);
    return "hi: " + message;
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    this.beanFactory = beanFactory;
  }

  @Override
  public void setBeanName(String s) {
    this.beanName = s;
  }
}
