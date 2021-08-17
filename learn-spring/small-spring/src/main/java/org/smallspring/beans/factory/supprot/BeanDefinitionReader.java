package org.smallspring.beans.factory.supprot;

import cn.hutool.core.bean.BeanException;
import org.smallspring.core.io.Resource;
import org.smallspring.core.io.ResourceLoader;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
public interface BeanDefinitionReader {

  BeanDefinitionRegistry getRegistry();

  ResourceLoader getResourceLoader();

  void loadBeanDefinitions(Resource resource) throws BeanException;

  void loadBeanDefinitions(Resource... resources) throws BeanException;

  void loadBeanDefinitions(String location) throws BeanException;

  void loadBeanDefinitions(String... locations) throws BeanException;
}
