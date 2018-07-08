package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public class GenericBeanDefinition implements BeanDefinition
{
	private String id;
	private String beanClassName;

	public GenericBeanDefinition(String id,String beanClassName)
	{
		this.id = id;
		this.beanClassName = beanClassName;
	}

	public String getBeanClassName()
	{
		return this.beanClassName;
	}
}
