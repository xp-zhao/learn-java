package aop;

import aop.convert.Convert;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import cn.hutool.json.JSONUtil;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 操作日志切面
 *
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
@Component
@Aspect
public class OperateAspect {
  /**
   * 1.定义切入点<br>
   * 2.横切逻辑<br>
   * 3.织入
   */
  @Pointcut("@annotation(aop.RecordOperate)")
  public void pointCut() {}

  private ThreadPoolExecutor threadPoolExecutor =
      new ThreadPoolExecutor(
          1,
          1,
          1,
          TimeUnit.SECONDS,
          new LinkedBlockingDeque<>(100),
          new ThreadFactoryBuilder().setNamePrefix("record-operate").build());

  @Around("pointCut()")
  public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    Object result = proceedingJoinPoint.proceed();
    threadPoolExecutor.execute(
        () -> {
          MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
          RecordOperate annotation = methodSignature.getMethod().getAnnotation(RecordOperate.class);

          Class<? extends Convert> convert = annotation.convert();
          try {
            Convert logConvert = convert.newInstance();
            OperateLogDTO logDto = logConvert.convert(proceedingJoinPoint.getArgs()[0]);
            logDto.setDesc(annotation.desc());
            logDto.setResult(result.toString());
            System.out.println("insert operateLog: " + JSONUtil.toJsonStr(logDto));
          } catch (Exception e) {
            e.printStackTrace();
          }
        });
    return result;
  }
}
