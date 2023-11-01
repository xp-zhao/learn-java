package com.example.feature.initializer;

import java.util.Arrays;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping @Description: @Date
 */
//@Component
public class CustomServletContextInitializer implements ServletContextInitializer {

  @Resource private AnnotationConfigServletWebServerApplicationContext applicationContext;

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    applicationContext.getBean("userController");
    BeanDefinitionRegistry registry = applicationContext;
    String[] singletonNames = applicationContext.getBeanFactory().getSingletonNames();
    for (String beanDefinitionName : registry.getBeanDefinitionNames()) {
      if (Arrays.stream(singletonNames).noneMatch(beanDefinitionName::equals)) {
        registry.removeBeanDefinition(beanDefinitionName);
      }
    }
  }
}
