package org.learn.spring.beans.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 对象属性注解
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
@Target({
  ElementType.FIELD,
  ElementType.METHOD,
  ElementType.PARAMETER,
  ElementType.TYPE,
  ElementType.ANNOTATION_TYPE
})
public @interface Qualifier {
  String value() default "";
}
