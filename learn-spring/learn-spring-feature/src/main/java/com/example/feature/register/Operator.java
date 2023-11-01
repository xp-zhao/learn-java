package com.example.feature.register;

import java.lang.annotation.*;

/**
 * 操作注解
 *
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Operator {
  /** spel expression */
  String value();
}
