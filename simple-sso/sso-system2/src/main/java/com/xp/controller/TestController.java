package com.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xp-zhao on 2018/1/24.
 */
@Controller
public class TestController
{
	@RequestMapping("/test")
	public String test(HttpServletRequest request,Model model)
	{
		return "test";
	}

	@RequestMapping("/success")
	public String success(HttpServletRequest request,Model model)
	{
		return "success";
	}
}
