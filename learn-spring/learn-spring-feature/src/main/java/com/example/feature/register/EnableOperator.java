package com.example.feature.register;

import java.lang.annotation.*;
import org.springframework.context.annotation.Import;

/**
 * 启动 Operator 的注解
 *
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(OperatorComponentRegister.class)
public @interface EnableOperator {
  /** 扫描路径 */
  String[] value() default {};
}
