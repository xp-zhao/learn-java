package com.xp.springsession.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xp-zhao on 2018/1/29.
 */
@Controller
@RequestMapping(value = "/spring/session")
public class SpringSessionController
{
	@RequestMapping(value = "/setSession.do",method = RequestMethod.GET)
	public void setSession(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		request.getSession().setAttribute(name,value);
		request.getSession().setAttribute(value,name);
	}

	@RequestMapping(value = "/getSession.do",method = RequestMethod.GET)
	public void getSession(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		System.out.println("++++++++++"+request.getSession().getAttribute(name)+"+++++++++++++");
	}

	@RequestMapping(value = "/removeSession.do",method = RequestMethod.GET)
	public void removeSession(HttpServletRequest request,HttpServletResponse response)
	{
		String name = request.getParameter("name");
		request.getSession().removeAttribute(name);
	}
}
