package org.learn.spring.context.annotation;

import java.lang.annotation.*;

/**
 * 配置作用域的自定义注解
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
  String value() default "singleton";
}
