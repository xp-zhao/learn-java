package org.litespring.beans.factory.config;

/**
 * Created by xp-zhao on 2018/7/24.
 */
public interface SingletonBeanRegistry
{
	void registerSingleton(String beanName, Object singletonObject);

	Object getSingleton(String beanName);
}
