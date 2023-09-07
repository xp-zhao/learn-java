package org.example.aop;

import java.lang.annotation.*;

/**
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLock {}
