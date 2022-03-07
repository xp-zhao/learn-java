package org.learn.spring.context.annotation;

import cn.hutool.core.util.StrUtil;
import java.util.Set;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.support.BeanDefinitionRegistry;
import org.learn.spring.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2022-3-7
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
  private BeanDefinitionRegistry registry;

  public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
    this.registry = registry;
  }

  public void doScan(String... basePackages) {
    for (String basePackage : basePackages) {
      Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
      for (BeanDefinition beanDefinition : candidates) {
        // 解析 Bean 的作用域 singleton、prototype
        String beanScope = resolveBeanScope(beanDefinition);
        if (StrUtil.isNotEmpty(beanScope)) {
          beanDefinition.setScope(beanScope);
        }
        registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
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
