package com.example.feature.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
public class ImportRegistry implements ImportBeanDefinitionRegistrar {
  @Override
  public void registerBeanDefinitions(
      AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setBeanClass(SimpleRegistry.class);
    registry.registerBeanDefinition("simpleRegistry", beanDefinition);
  }
}
