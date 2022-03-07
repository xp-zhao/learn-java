package org.learn.spring.aop.aspectj;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;
import org.learn.spring.aop.ClassFilter;
import org.learn.spring.aop.MethodMatcher;
import org.learn.spring.aop.Pointcut;

/**
 * 切点表达式
 *
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

  private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES =
      new HashSet<PointcutPrimitive>();

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
