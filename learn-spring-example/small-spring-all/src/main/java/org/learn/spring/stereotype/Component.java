package org.learn.spring.stereotype;

import java.lang.annotation.*;

/**
 * 配置到类上的自定义注解
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
  String value() default "";
}
