package com.xp.spring.bean.definition;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description: {@link BeanDefinition} 构建示例
 * @Date 2021-3-26
 **/
public class BeanDefinitionCreationDemo {

  public static void main(String[] args) {
    // 1. 通过 BeanDefinitionBuilder 构建
    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
        .genericBeanDefinition(User.class);
    // 通过属性配置
//    beanDefinitionBuilder.addPropertyValue("id", 1);
//    beanDefinitionBuilder.addPropertyValue("name", "xp");
    beanDefinitionBuilder.addPropertyValue("id", 1).addPropertyValue("name", "xp");
    // 获取 BeanDefinition 实例
    BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
    // BeanDefinition 并非 Bean 最终状态，可以自定义修改

    // 2. 通过 AbstractBeanDefinition 以及派生类
    GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
    // 设置 Bean 类型
    genericBeanDefinition.setBeanClass(User.class);
    // 通过 MutablePropertyValues 批量操作属性
    MutablePropertyValues propertyValues = new MutablePropertyValues();
//    propertyValues.addPropertyValue("id", 1);
//    propertyValues.addPropertyValue("name", "xp");
    // 链式调用
    propertyValues.add("id", 1).add("name", "xp");
    // 通过 set MutablePropertyValues 批量操作属性
    genericBeanDefinition.setPropertyValues(propertyValues);
  }
}
