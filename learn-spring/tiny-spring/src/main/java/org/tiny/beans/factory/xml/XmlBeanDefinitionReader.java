package org.tiny.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import java.io.IOException;
import java.io.InputStream;
import org.tiny.beans.BeansException;
import org.tiny.beans.PropertyValue;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.BeanReference;
import org.tiny.beans.factory.support.AbstractBeanDefinitionReader;
import org.tiny.beans.factory.support.BeanDefinitionRegistry;
import org.tiny.core.io.Resource;
import org.tiny.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/** @author zhaoxiaoping @Description: 解析 xml 获取 bean 定义实现 @Date 2021-8-20 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

  public static final String ID_ATTRIBUTE = "id";

  public static final String CLASS_ATTRIBUTE = "class";

  public static final String REF_ATTRIBUTE = "ref";

  public static final String VALUE_ATTRIBUTE = "value";

  public static final String NAME_ATTRIBUTE = "name";

  public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
    super(registry);
  }

  public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
    super(registry, resourceLoader);
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

  /**
   * 通过输入流加载 bean 定义信息
   *
   * @param inputStream 输入流
   * @throws ClassNotFoundException 异常抛出
   */
  protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
    Document doc = XmlUtil.readXML(inputStream);
    Element root = doc.getDocumentElement();
    NodeList childNodes = root.getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++) {
      // 判断元素
      if (!(childNodes.item(i) instanceof Element)) {
        continue;
      }
      // 判断对象
      if (!"bean".equals(childNodes.item(i).getNodeName())) {
        continue;
      }

      // 解析标签
      Element bean = (Element) childNodes.item(i);
      String id = bean.getAttribute(ID_ATTRIBUTE);
      String name = bean.getAttribute(NAME_ATTRIBUTE);
      String className = bean.getAttribute(CLASS_ATTRIBUTE);
      // 获取 Class，方便获取类中的名称
      Class<?> clazz = Class.forName(className);
      // 优先级 id > name
      String beanName = StrUtil.isNotEmpty(id) ? id : name;
      if (StrUtil.isEmpty(beanName)) {
        beanName = StrUtil.lowerFirst(clazz.getSimpleName());
      }

      // 定义Bean
      BeanDefinition beanDefinition = new BeanDefinition(clazz);
      // 读取属性并填充
      for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
        if (!(bean.getChildNodes().item(j) instanceof Element)) {
          continue;
        }
        if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) {
          continue;
        }
        // 解析标签：property
        Element property = (Element) bean.getChildNodes().item(j);
        String attrName = property.getAttribute(NAME_ATTRIBUTE);
        String attrValue = property.getAttribute(VALUE_ATTRIBUTE);
        String attrRef = property.getAttribute(REF_ATTRIBUTE);
        // 获取属性值：引入对象、值对象
        Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
        // 创建属性信息
        PropertyValue propertyValue = new PropertyValue(attrName, value);
        beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
      }
      if (getRegistry().containsBeanDefinition(beanName)) {
        throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
      }
      // 注册 BeanDefinition
      getRegistry().registerBeanDefinition(beanName, beanDefinition);
    }
  }
}
