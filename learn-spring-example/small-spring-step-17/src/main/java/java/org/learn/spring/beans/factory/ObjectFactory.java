package java.org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * Defines a factory which can return an Object instance <br>
 * (possibly shared or independent) when invoked.
 *
 * @author zhaoxiaoping
 * @date 2022-5-7
 */
public interface ObjectFactory<T> {
  /**
   * 获取对象
   *
   * @return {@code T}
   * @throws BeansException 异常
   */
  T getObject() throws BeansException;
}
