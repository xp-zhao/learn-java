package aop.convert;

import aop.OperateLogDTO;

/**
 * 转换接口
 *
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
public interface Convert<P> {
  /**
   * 转换
   *
   * @param p p
   * @return {@code OperateLogDTO}
   */
  OperateLogDTO convert(P p);
}
