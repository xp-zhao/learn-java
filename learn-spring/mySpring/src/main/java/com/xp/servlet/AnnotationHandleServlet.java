package com.xp.servlet;
import com.xp.annotation.RequestMapping;
import com.xp.utils.BeanUtils;
import com.xp.utils.RequestMappingMap;
import com.xp.utils.WebContext;
import com.xp.view.DispatchActionConstant;
import com.xp.view.View;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义注解的核心处理器以及负责调用目标业务方法处理用户请求
 * Created by xp-zhao on 2018/4/12.
 */
public class AnnotationHandleServlet extends HttpServlet
{
	private String pareRequestURI(HttpServletRequest request)
	{
		String path = request.getContextPath() + "/";
		String requestUri = request.getRequestURI();
		String midUrl = requestUri.replaceFirst(path,"");
		String lastUrl = midUrl.substring(0,midUrl.lastIndexOf("."));
		return lastUrl;
	}

	private void excute(HttpServletRequest request,HttpServletResponse response)
	{
		//将当前线程中的 HttpServletRequest 和 HttpServletResponse 保存到 ThreadLocal 中
		WebContext.requestHodler.set(request);
		WebContext.responseHodler.set(response);
		// 解析 url
		String lasturl = pareRequestURI(request);
		// 获取要使用的类
		Class<?> clazz = RequestMappingMap.getRequestMap().get(lasturl);
		// 创建类的实例
		Object classInstance = BeanUtils.instanceClass(clazz);
		// 获取类中定义的方法
		Method[] methods = BeanUtils.findDeclareMethods(clazz);
		Method method = null;
		for(Method m : methods)
		{
			if(m.isAnnotationPresent(RequestMapping.class))
			{
				String path = m.getAnnotation(RequestMapping.class).value();
				if(path != null && !"".equals(path.trim()) && lasturl.equals(path.trim()))
				{
					method = m;
					break;
				}
			}
		}
		try
		{
			if(method != null)
			{
				// 执行目标方法处理用户请求
				Object object = method.invoke(classInstance);
				// 有返回值，表示用户需要返回视图
				if(object != null)
				{
					View view = (View) object;
					if(view.getDispathAction().equals(DispatchActionConstant.FORWARD))
					{
						//使用服务器端跳转方式
						request.getRequestDispatcher(view.getUrl()).forward(request,response);
					}
					else if(view.getDispathAction().equals(DispatchActionConstant.REDIRECT))
					{
						//使用客户端跳转方式
						response.sendRedirect(request.getContextPath()+view.getUrl());
					}
					else
					{
						request.getRequestDispatcher(view.getUrl()).forward(request,response);
					}

				}
			}
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
		catch (ServletException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
