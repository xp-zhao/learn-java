package com.xp.controller;

import com.xp.utils.RedisUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xp-zhao on 2018/7/9.
 */
@Controller
public class LoginController
{
	@RequestMapping (value = "/hello/helloWorld.do",method= RequestMethod.GET)
	public String helloWorld(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException
	{
		String sessionId = request.getSession().getId();
		RedisUtil.set("system1-sessionId:" , sessionId);
		System.out.println("sessionId: "+sessionId);
		return "index";
	}
}
