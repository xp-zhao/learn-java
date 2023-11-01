package com.example.feature.register;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @author zhaoxiaoping
 * @date 2023-10-30
 */
public class OperatorFactoryBean implements FactoryBean<Object>, InitializingBean {

  private Class<?> type;
  private String expression;
  private Expression spelExpression;

  @Override
  public Object getObject() throws Exception {
    return Proxy.newProxyInstance(
        type.getClassLoader(),
        new Class<?>[] {type},
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            EvaluationContext context = new StandardEvaluationContext();
            char argName = 'a';
            for (Object arg : args) {
              context.setVariable(String.valueOf(argName++), arg);
            }
            return spelExpression.getValue(context);
          }
        });
  }

  @Override
  public Class<?> getObjectType() {
    return this.type;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    ExpressionParser parser = new SpelExpressionParser();
    this.spelExpression = parser.parseExpression(this.expression);
  }

  public Class<?> getType() {
    return type;
  }

  public void setType(Class<?> type) {
    this.type = type;
  }

  public String getExpression() {
    return expression;
  }

  public void setExpression(String expression) {
    this.expression = expression;
  }
}
