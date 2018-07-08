package org.litespring.beans.factory;
import org.litespring.beans.BeanDefinition;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public interface BeanFactory
{
	BeanDefinition getBeanDefinition(String beanId);

	Object getBean(String beanId);
}
