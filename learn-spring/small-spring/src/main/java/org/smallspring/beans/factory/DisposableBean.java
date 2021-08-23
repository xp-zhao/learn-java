package org.smallspring.beans.factory;

/**
 * @author zhaoxiaoping
 * @Description: 一次性 bean 接口
 * @Date 2021-8-23
 **/
public interface DisposableBean {

  /**
   * 销毁 bean
   * @throws Exception
   */
  void destroy() throws Exception;

}
