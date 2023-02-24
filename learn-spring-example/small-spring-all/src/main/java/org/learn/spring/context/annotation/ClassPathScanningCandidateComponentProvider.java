package org.learn.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 对象扫描装配处理器
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
public class ClassPathScanningCandidateComponentProvider {
  public Set<BeanDefinition> findCandidateComponents(String basePackage) {
    Set<BeanDefinition> candidates = new LinkedHashSet<>();
    Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
    for (Class<?> clazz : classes) {
      candidates.add(new BeanDefinition(clazz));
    }
    return candidates;
  }
}
