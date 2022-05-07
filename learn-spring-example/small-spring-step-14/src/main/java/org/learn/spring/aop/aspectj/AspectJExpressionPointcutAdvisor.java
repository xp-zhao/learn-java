package org.learn.spring.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.learn.spring.aop.Pointcut;
import org.learn.spring.aop.PointcutAdvisor;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

  /** 切面 */
  private AspectJExpressionPointcut pointcut;

  /** 具体的拦截方法 */
  private Advice advice;

  /** 表达式 */
  private String expression;

  @Override
  public Pointcut getPointcut() {
    if (null == pointcut) {
      pointcut = new AspectJExpressionPointcut(expression);
    }
    return pointcut;
  }

  @Override
  public Advice getAdvice() {
    return advice;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }

  public void setAdvice(Advice advice) {
    this.advice = advice;
  }
}
