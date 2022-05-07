package org.learn.spring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import java.util.LinkedHashSet;
import java.util.Set;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.stereotype.Component;

/**
 * 处理对象扫描装配
 *
 * @author zhaoxiaoping
 * @date 2022-3-7
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
