package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * 对象工厂
 *
 * @author zhaoxiaoping
 * @date 2023-2-28
 */
public interface ObjectFactory<T> {
  T getObject() throws BeansException;
}
