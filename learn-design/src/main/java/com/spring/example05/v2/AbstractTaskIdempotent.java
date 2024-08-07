package com.spring.example05.v2;

import com.spring.example05.v2.common.ResultEnum;
import com.spring.example05.v2.context.BaseProcessContext;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象任务幂等模版类
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Slf4j
public abstract class AbstractTaskIdempotent<T extends BaseProcessContext>
    implements Task<T>, Idempotent<T> {

  /**
   * 子类处理业务逻辑的入口
   *
   * @param context 上下文
   * @return 执行结果
   */
  protected abstract T executeBusinessLogic(T context);

  @Override
  public T execute(T context) {
    // 拿到当前执行的任务名称
    String simpleName = this.getClass().getSimpleName();
    Optional<String> idempotentKey = getIdempotentKey(context);
    try {
      // 执行业务逻辑
      context = executeBusinessLogic(context);
    } catch (Exception e) {
      // 执行失败，则抛出异常
      log.error(simpleName + " marked error, the idempotent key:{}", idempotentKey);
      context.setResult(ResultEnum.FAIL);
    }
    return context;
  }

  @Override
  public Optional<String> getIdempotentKey(T context) {
    return Optional.empty();
  }
}
