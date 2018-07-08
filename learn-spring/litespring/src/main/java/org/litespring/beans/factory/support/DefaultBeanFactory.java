package org.litespring.beans.factory.support;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.litespring.beans.BeanDefinition;
import org.litespring.beans.factory.BeanCreationException;
import org.litespring.beans.factory.BeanDefinitionStoreException;
import org.litespring.beans.factory.BeanFactory;
import org.litespring.util.ClassUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public class DefaultBeanFactory implements BeanFactory
{
	public static final String                     ID_ATTRIBUTE      = "id";

	public static final String                     CLASS_ATTRIBUTE   = "class";
	public final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	public DefaultBeanFactory(String configFile)
	{
		loadBeanDefiniton(configFile);
	}

	private void loadBeanDefiniton(String configFile)
	{
		InputStream is = null;
		try
		{
			ClassLoader cl = ClassUtils.getDefaultClassLoader();
			is = cl.getResourceAsStream(configFile);

			SAXReader reader = new SAXReader();
			Document doc = reader.read(is);

			Element root = doc.getRootElement(); // <beans>
			Iterator<Element> iter = root.elementIterator();
			while(iter.hasNext())
			{
				Element ele = iter.next();
				String id = ele.attributeValue(ID_ATTRIBUTE);
				String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id,beanClassName);
				this.beanDefinitionMap.put(id , bd);
			}
		}
		catch (Exception e)
		{
			throw new BeanDefinitionStoreException("IOException parsing XML",e);
		}
		finally
		{
			if(is != null)
			{
				try
				{
					is.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public BeanDefinition getBeanDefinition(String beanId)
	{
		return this.beanDefinitionMap.get(beanId);
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
