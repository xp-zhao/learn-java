package org.learn.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanReference;
import org.learn.spring.beans.factory.support.AbstractBeanDefinitionReader;
import org.learn.spring.beans.factory.support.BeanDefinitionRegistry;
import org.learn.spring.core.io.Resource;
import org.learn.spring.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 从 xml 中读取 BeanDefinition 实现类
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
  public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
    super(beanDefinitionRegistry);
  }

  public XmlBeanDefinitionReader(
      BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
    super(beanDefinitionRegistry, resourceLoader);
  }

  @Override
  public void loadBeanDefinitions(Resource resource) throws BeansException {
    try {
      try (InputStream inputStream = resource.getInputStream()) {
        doLoadBeanDefinitions(inputStream);
      }
    } catch (IOException | ClassNotFoundException e) {
      throw new BeansException("IOException parsing XML document from " + resource, e);
    }
  }

  @Override
  public void loadBeanDefinitions(Resource... resources) throws BeansException {
    for (Resource resource : resources) {
      loadBeanDefinitions(resource);
    }
  }

  @Override
  public void loadBeanDefinitions(String location) throws BeansException {
    ResourceLoader resourceLoader = getResourceLoader();
    Resource resource = resourceLoader.getResource(location);
    loadBeanDefinitions(resource);
  }

  @Override
  public void loadBeanDefinitions(String... locations) throws BeansException {
    for (String location : locations) {
      loadBeanDefinitions(location);
    }
  }

  protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
    Document document = XmlUtil.readXML(inputStream);
    Element root = document.getDocumentElement();
    NodeList childNodes = root.getChildNodes();

    for (int i = 0; i < childNodes.getLength(); i++) {
      // 判断是否是 xml 元素
      if (!(childNodes.item(i) instanceof Element)) {
        continue;
      }
      // 判断是否是 bean 对象标签
      if (!"bean".equals(childNodes.item(i).getNodeName())) {
        continue;
      }
      // 解析标签
      Element bean = (Element) childNodes.item(i);
      String id = bean.getAttribute("id");
      String name = bean.getAttribute("name");
      String className = bean.getAttribute("class");
      String initMethodName = bean.getAttribute("init-method");
      String destroyMethodName = bean.getAttribute("destroy-method");
      String scope = bean.getAttribute("scope");
      Class<?> clazz = Class.forName(className);
      // beanName 优先级 id > name
      String beanName = StrUtil.isNotEmpty(id) ? id : name;
      if (StrUtil.isEmpty(beanName)) {
        beanName = StrUtil.lowerFirst(clazz.getSimpleName());
      }
      // 定义 BeanDefinition 对象
      BeanDefinition beanDefinition = new BeanDefinition(clazz);
      beanDefinition.setInitMethodName(initMethodName);
      beanDefinition.setDestroyMethodName(destroyMethodName);
      if (StrUtil.isNotBlank(scope)) {
        beanDefinition.setScope(scope);
      }
      // 读取 bean 属性并填充
      for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
        if (!(bean.getChildNodes().item(j) instanceof Element)) {
          continue;
        }
        if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
          continue;
        }
        // 解析属性标签 property
        Element property = (Element) bean.getChildNodes().item(j);
        String attrName = property.getAttribute("name");
        String attrValue = property.getAttribute("value");
        String attrRef = property.getAttribute("ref");
        // 获取属性值, 可能是引用对象或值对象
        Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
        // 创建属性信息
        PropertyValue propertyValue = new PropertyValue(attrName, value);
        beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
      }
      // 判断是否有重名的 bean
      if (getRegistry().containsBeanDefinition(beanName)) {
        throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
      }
      // 注册 BeanDefinition
      getRegistry().registerBeanDefinition(beanName, beanDefinition);
    }
  }
}
