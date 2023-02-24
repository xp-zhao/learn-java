package org.learn.spring.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanReference;
import org.learn.spring.beans.factory.support.AbstractBeanDefinitionReader;
import org.learn.spring.beans.factory.support.BeanDefinitionRegistry;
import org.learn.spring.context.annotation.ClassPathBeanDefinitionScanner;
import org.learn.spring.core.io.Resource;
import org.learn.spring.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
    } catch (IOException | DocumentException | ClassNotFoundException e) {
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

  protected void doLoadBeanDefinitions(InputStream inputStream)
      throws ClassNotFoundException, DocumentException {
    SAXReader reader = new SAXReader();
    Document document = reader.read(inputStream);
    Element root = document.getRootElement();

    // 解析 context:component-scan 标签，扫描包中的类并提取相关信息，用于组装 BeanDefinition
    Element componentScan = root.element("component-scan");
    if (null != componentScan) {
      String scanPath = componentScan.attributeValue("base-package");
      if (StrUtil.isEmpty(scanPath)) {
        throw new BeansException("The value of base-package attribute can not be empty or null");
      }
      scanPackage(scanPath);
    }
    List<Element> beanList = root.elements("bean");
    for (Element bean : beanList) {
      // 解析标签
      String id = bean.attributeValue("id");
      String name = bean.attributeValue("name");
      String className = bean.attributeValue("class");
      String initMethodName = bean.attributeValue("init-method");
      String destroyMethodName = bean.attributeValue("destroy-method");
      String scope = bean.attributeValue("scope");
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
      List<Element> propertyList = bean.elements("property");
      // 读取 bean 属性并填充
      for (Element property : propertyList) {
        String attrName = property.attributeValue("name");
        String attrValue = property.attributeValue("value");
        String attrRef = property.attributeValue("ref");
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

  private void scanPackage(String scanPath) {
    String[] basePackages = StrUtil.splitToArray(scanPath, ',');
    ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(getRegistry());
    scanner.doScan(basePackages);
  }
}
