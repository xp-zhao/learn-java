package com.xp.controller;

import com.xp.annotation.Controller;
import com.xp.annotation.RequestMapping;
import com.xp.view.View;

/**
 * Created by xp-zhao on 2018/5/4.
 */
@Controller
public class LoginUI
{
	@RequestMapping("LoginUI/Login2")
	public View forward1()
	{
		return new View("/login2.jsp");
	}
}
