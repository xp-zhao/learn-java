package org.learn.spring.aop.aspectj;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.learn.spring.aop.ClassFilter;
import org.learn.spring.aop.MethodMatcher;
import org.learn.spring.aop.Pointcut;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * 切入点表达式
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

  public static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<>();

  static {
    SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
  }

  private final PointcutExpression pointcutExpression;

  public AspectJExpressionPointcut(String expression) {
    PointcutParser pointcutParser =
        PointcutParser
            .getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(
                SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
    this.pointcutExpression = pointcutParser.parsePointcutExpression(expression);
  }

  @Override
  public boolean matches(Class<?> clazz) {
    return pointcutExpression.couldMatchJoinPointsInType(clazz);
  }

  @Override
  public boolean matches(Method method, Class<?> targetClass) {
    return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
  }

  @Override
  public ClassFilter getClassFilter() {
    return this;
  }

  @Override
  public MethodMatcher getMethodMatcher() {
    return this;
  }
}
