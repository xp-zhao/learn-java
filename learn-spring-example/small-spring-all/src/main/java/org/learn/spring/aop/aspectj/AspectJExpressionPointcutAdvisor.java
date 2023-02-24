package org.learn.spring.aop.aspectj;

import org.aopalliance.aop.Advice;
import org.learn.spring.aop.Pointcut;
import org.learn.spring.aop.PointcutAdvisor;

/**
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

  /** 切面 */
  private AspectJExpressionPointcut pointcut;

  /** 具体的拦截方法 */
  private Advice advice;

  /** 表达式 */
  private String expression;

  @Override
  public Advice getAdvice() {
    return advice;
  }

  @Override
  public Pointcut getPointcut() {
    if (pointcut == null) {
      pointcut = new AspectJExpressionPointcut(expression);
    }
    return pointcut;
  }

  public void setAdvice(Advice advice) {
    this.advice = advice;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }
}
