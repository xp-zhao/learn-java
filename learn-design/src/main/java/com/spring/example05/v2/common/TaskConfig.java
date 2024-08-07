package com.spring.example05.v2.common;

import java.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * task 自定义注解
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface TaskConfig {
  String name();
}
