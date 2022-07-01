package java.org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.core.io.Resource;
import org.learn.spring.core.io.ResourceLoader;

/**
 * Bean 定义读取接口
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface BeanDefinitionReader {
  /**
   * 获取 bean 定义注册接口
   *
   * @return {@link BeanDefinitionRegistry}
   */
  BeanDefinitionRegistry getRegistry();

  /**
   * 获取资源加载器
   *
   * @return {@link ResourceLoader}
   */
  ResourceLoader getResourceLoader();

  /**
   * 加载bean定义
   *
   * @param resource 资源
   * @throws BeansException 异常
   */
  void loadBeanDefinitions(Resource resource) throws BeansException;

  /**
   * 加载bean定义
   *
   * @param resources 资源
   * @throws BeansException 异常
   */
  void loadBeanDefinitions(Resource... resources) throws BeansException;

  /**
   * 加载bean定义
   *
   * @param location 位置
   * @throws BeansException 异常
   */
  void loadBeanDefinitions(String location) throws BeansException;

  /**
   * 加载bean定义
   *
   * @param locations 位置
   * @throws BeansException 异常
   */
  void loadBeanDefinitions(String... locations) throws BeansException;
}
