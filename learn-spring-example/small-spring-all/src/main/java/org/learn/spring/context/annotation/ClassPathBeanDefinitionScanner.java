package org.learn.spring.context.annotation;

import cn.hutool.core.util.StrUtil;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.support.BeanDefinitionRegistry;
import org.learn.spring.stereotype.Component;

import java.util.Set;

/**
 * ClassPath BeanDefinition 扫描器
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
  private BeanDefinitionRegistry beanDefinitionRegistry;

  public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry beanDefinitionRegistry) {
    this.beanDefinitionRegistry = beanDefinitionRegistry;
  }

  public void doScan(String... basePackages) {
    for (String basePackage : basePackages) {
      Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
      for (BeanDefinition beanDefinition : candidates) {
        String beanScope = resolveBeanScope(beanDefinition);
        if (StrUtil.isNotEmpty(beanScope)) {
          beanDefinition.setScope(beanScope);
        }
        beanDefinitionRegistry.registerBeanDefinition(
            determineBeanName(beanDefinition), beanDefinition);
      }
    }
  }

  private String resolveBeanScope(BeanDefinition beanDefinition) {
    Class<?> beanClass = beanDefinition.getBeanClass();
    Scope scope = beanClass.getAnnotation(Scope.class);
    if (null != scope) {
      return scope.value();
    }
    return StrUtil.EMPTY;
  }

  private String determineBeanName(BeanDefinition beanDefinition) {
    Class<?> beanClass = beanDefinition.getBeanClass();
    Component component = beanClass.getAnnotation(Component.class);
    String value = component.value();
    if (StrUtil.isEmpty(value)) {
      value = StrUtil.lowerFirst(beanClass.getSimpleName());
    }
    return value;
  }
}
