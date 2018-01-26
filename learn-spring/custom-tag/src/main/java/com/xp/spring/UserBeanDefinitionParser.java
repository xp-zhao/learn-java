package com.xp.spring;

import com.xp.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by xp-zhao on 2018/1/25.
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser
{
	@Override
	protected Class<?> getBeanClass(Element element)
	{
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");

		if(StringUtils.hasText(userName))
		{
			builder.addPropertyValue("userName",userName);
			builder.addPropertyValue("email",email);
		}
	}
}
