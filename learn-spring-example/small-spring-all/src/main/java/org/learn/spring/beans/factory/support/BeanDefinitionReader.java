package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.core.io.Resource;
import org.learn.spring.core.io.ResourceLoader;

/**
 * BeanDefinition 读取接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface BeanDefinitionReader {
  /**
   * 获取 BeanDefinition 注册接口
   *
   * @return
   */
  BeanDefinitionRegistry getRegistry();

  /**
   * 获取资源加载接口
   *
   * @return
   */
  ResourceLoader getResourceLoader();

  /**
   * 加载 BeanDefinition
   *
   * @param resource
   * @throws BeansException
   */
  void loadBeanDefinitions(Resource resource) throws BeansException;

  /**
   * 加载 BeanDefinition
   *
   * @param resource
   * @throws BeansException
   */
  void loadBeanDefinitions(Resource... resource) throws BeansException;

  /**
   * 加载 BeanDefinition
   *
   * @param location 资源位置
   * @throws BeansException
   */
  void loadBeanDefinitions(String location) throws BeansException;
}
