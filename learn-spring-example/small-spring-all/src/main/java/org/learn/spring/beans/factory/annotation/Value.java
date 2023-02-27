package org.learn.spring.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * 对象属性注解
 *
 * @author zhaoxiaoping
 * @date 2023-2-27
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
  String value();
}
