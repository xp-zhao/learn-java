package org.tiny.beans.factory.support;

import org.tiny.core.io.Resource;
import org.tiny.beans.BeansException;
import org.tiny.core.io.ResourceLoader;

/** @author zhaoxiaoping @Description: bean 定义读取接口 (从资源信息中获取 bean 定义信息) @Date 2021-8-20 */
public interface BeanDefinitionReader {

  /**
   * 获取 bean 定义注册接口
   *
   * @return BeanDefinitionRegistry
   */
  BeanDefinitionRegistry getRegistry();

  /**
   * 获取资源获取接口
   *
   * @return 资源获取接口
   */
  ResourceLoader getResourceLoader();

  /**
   * 通过单个资源加载 bean 定义信息
   *
   * @param resource 单个资源
   * @throws BeansException 加载失败时抛出
   */
  void loadBeanDefinitions(Resource resource) throws BeansException;

  /**
   * 通过多个资源加载 bean 定义信息
   *
   * @param resources 多个个资源
   * @throws BeansException 加载失败时抛出
   */
  void loadBeanDefinitions(Resource... resources) throws BeansException;

  /**
   * 通过指定地址加载 bean 定义信息
   *
   * @param location 资源地址
   * @throws BeansException 加载失败时抛出
   */
  void loadBeanDefinitions(String location) throws BeansException;

  /**
   * 通过指定地址加载 bean 定义信息
   *
   * @param locations 资源地址
   * @throws BeansException 加载失败时抛出
   */
  void loadBeanDefinitions(String... locations) throws BeansException;
}
