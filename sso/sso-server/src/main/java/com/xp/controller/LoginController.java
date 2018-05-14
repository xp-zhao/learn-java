package com.xp.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xp-zhao on 2018/5/14.
 */
@Controller
public class LoginController
{
	@RequestMapping (value = "/index.do",method= RequestMethod.GET)
	public String helloWorld(HttpServletRequest request,Model model)
	{
		model.addAttribute("message" , "Hello World,this is a message");
		return "helloWorld";
	}

	@RequestMapping (value = "/login.do",method= RequestMethod.GET)
	public String login(HttpServletRequest request,Model model)
	{
		return "login";
	}
	@RequestMapping(value="login", method={RequestMethod.POST})
	@ResponseBody
	public String login(HttpServletRequest request,HttpSession session, Model model,
		@RequestParam (value="username", required=false) String name,
		@RequestParam(value="password", required=false) String password) {
		if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password))
		{
			return "success";
		}
		return "faild";
	}
}
