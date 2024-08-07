package com.spring.example05.v2;

import com.spring.example05.v2.context.BaseProcessContext;
import java.util.Optional;

/**
 * 幂等接口
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
public interface Idempotent<T extends BaseProcessContext> {
  /**
   * 获取幂等key，不存在则代表不需要幂等
   *
   * @param context 上下文
   * @return 幂等key
   */
  Optional<String> getIdempotentKey(T context);
}
