package org.litespring.beans.factory.config;

import org.litespring.beans.factory.BeanFactory;

/**
 * 提供设置 classloader 的能力
 * Created by xp-zhao on 2018/7/24.
 */
public interface ConfigurableBeanFactory extends BeanFactory
{
	void setBeanClassLoader(ClassLoader beanClassLoader);
	ClassLoader getBeanClassLoader();
}
