package org.litespring.core.type;

import org.litespring.core.annotation.AnnotationAttributes;

import java.util.Set;

/**
 * @author xp-zhao
 * @date 2018/12/23
 */
public interface AnnotationMetadata extends ClassMetadata {

  /**
   * 获取注解类型
   *
   * @return 注解类型
   */
  Set<String> getAnnotationTypes();

  /**
   * 是否有注解
   *
   * @param annotationType 注解类型
   * @return true/false
   */
  boolean hasAnnotation(String annotationType);

  /**
   * 获取注解属性
   *
   * @param annotationType 注解类型
   * @return 注解属性
   */
  AnnotationAttributes getAnnotationAttributes(String annotationType);
}
