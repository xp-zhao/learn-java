package com.xp.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by xp-zhao on 2018/1/25.
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport
{
	@Override
	public void init()
	{
		this.registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
	}
}
