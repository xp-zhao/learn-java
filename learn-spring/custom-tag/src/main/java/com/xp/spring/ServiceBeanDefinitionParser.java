package com.xp.spring;

import com.xp.entity.RpcService;
import com.xp.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by xp-zhao on 2018/1/25.
 */
public class ServiceBeanDefinitionParser extends AbstractSingleBeanDefinitionParser
{
	@Override
	protected Class<?> getBeanClass(Element element)
	{
		return RpcService.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {

		String contact = element.getAttribute("contact");
		String serviceName = element.getAttribute("serviceName");
		String serviceImplName = element.getAttribute("serviceImplName");

		if(StringUtils.hasText(contact))
		{
			builder.addPropertyValue("contact",contact);
			builder.addPropertyValue("serviceName",serviceName);
			builder.addPropertyValue("serviceImplName",serviceImplName);
		}
	}
}
