package com.xp.sso.controller;

import com.xp.sso.constant.AuthConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xp-zhao on 2018/1/24.
 */
@Controller
public class IndexController
{
	@RequestMapping("/")
	public String index(HttpServletRequest request,Model model)
	{
		model.addAttribute(AuthConst.CLIENT_URL,request.getParameter(AuthConst.CLIENT_URL));
		return "index";
	}

	@RequestMapping("/success")
	public String success()
	{
		return "success";
	}

	@RequestMapping("/demo")
	public String test()
	{
		return "demo";
	}
}
