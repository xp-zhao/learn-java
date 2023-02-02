package org.learn.spring.test.beans;

import java.lang.reflect.Method;
import org.learn.spring.aop.MethodBeforeAdvice;

public class SpouseAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("关怀小两口(切面)：" + method);
    }

}
