package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.util.ClassUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public class DefaultBeanFactory implements BeanFactory,BeanDefinitionRegistry
{
	public final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	public DefaultBeanFactory()
	{
	}


	public BeanDefinition getBeanDefinition(String beanId)
	{
		return this.beanDefinitionMap.get(beanId);
	}

	public void registerBeanDefinition(String beanID , BeanDefinition bd)
	{
		this.beanDefinitionMap.put(beanID , bd);
	}

	public Object getBean(String beanId)
	{
		BeanDefinition bd = this.getBeanDefinition(beanId);
		if(bd == null)
		{
			throw new BeanCreationException("Bean Definiton does not exist");
		}
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		String beanClassName = bd.getBeanClassName();
		try
		{
			Class<?> clz = cl.loadClass(beanClassName);
			return clz.newInstance();
		}
		catch (Exception e)
		{
			throw new BeanCreationException("create bean for "+ beanClassName +" failed",e);
		}
	}
}
