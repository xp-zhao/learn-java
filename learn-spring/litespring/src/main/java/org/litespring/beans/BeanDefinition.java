package org.litespring.beans;

import java.util.List;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public interface BeanDefinition
{
	String SCOPE_SINGLETON = "singleton";
	String SCOPE_PROTOTYPE = "prototype";
	String SCOPE_DEFAULT = "";

	boolean isSingleton();
	boolean isPrototype();
	String getScope();
	void setScope(String scope);

	String getBeanClassName();

	List<PropertyValue> getPropertyValues();

	ConstructorArgument getConstructorArgument();
}
