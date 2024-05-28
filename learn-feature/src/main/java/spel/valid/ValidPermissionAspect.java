package spel.valid;

import cn.hutool.core.util.StrUtil;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.expression.EvaluationContext;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2024-5-28
 */
@Slf4j
@Aspect
@Component
public class ValidPermissionAspect {
  private ExpressionEvaluator<String> evaluator = new ExpressionEvaluator<>();

  @Pointcut("@annotation(spel.valid.ValidPermission)")
  private void pointCut() {}

  @Before("pointCut()")
  public void doPermission(JoinPoint joinPoint) {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Method method = methodSignature.getMethod();
    ValidPermission permission = method.getAnnotation(ValidPermission.class);
    if (joinPoint.getArgs() == null) {
      return;
    }

    // [重点]EL表达式的方式读取对应参数值
    EvaluationContext evaluationContext =
        evaluator.createEvaluationContext(
            joinPoint.getTarget(),
            joinPoint.getTarget().getClass(),
            ((MethodSignature) joinPoint.getSignature()).getMethod(),
            joinPoint.getArgs());
    AnnotatedElementKey methodKey =
        new AnnotatedElementKey(
            ((MethodSignature) joinPoint.getSignature()).getMethod(),
            joinPoint.getTarget().getClass());

    // 读取 userId，如果以#开头则按照EL处理，否则按照普通字符串处理
    String userId;
    if (StrUtil.startWith(permission.userId(), "#")) {
      userId = evaluator.condition(permission.userId(), methodKey, evaluationContext, String.class);
    } else {
      userId = permission.userId();
    }
    log.info("userId: {}", userId);
  }
}
