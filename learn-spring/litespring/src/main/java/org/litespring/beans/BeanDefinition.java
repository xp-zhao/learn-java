package org.litespring.beans;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public interface BeanDefinition
{
	public static final String SCOPE_SINGLETON = "singleton";
	public static final String SCOPE_PROTOTYPE = "prototype";
	public static final String SCOPE_DEFAULT = "";

	public boolean isSingleton();
	public boolean isPrototype();
	String getScope();
	void setScope(String scope);

	public String getBeanClassName();
}
