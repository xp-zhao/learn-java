package org.litespring.beans.factory.support;

import org.litespring.beans.BeanDefinition;

/**
 * Created by xp-zhao on 2018/7/9.
 */
public interface BeanDefinitionRegistry
{
	BeanDefinition getBeanDefinition(String beanID);

	void registerBeanDefinition(String beanID, BeanDefinition bd);
}
