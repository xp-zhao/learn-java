package com.xp.define;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 方式三：使用注解实现 AOP
 */

@Aspect // 表示这个类是一个切面
public class AnnotationPointCut {

    @Before("execution(* com.xp.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("方法执行前");
    }

    @After("execution(* com.xp.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }

    /**
     * 在环绕增强中，我们可以给的一个参数，代表我们要获取处理切入的点
     */
    @Around("execution(* com.xp.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕前");
        point.proceed();
        System.out.println("环绕后");
    }
}
