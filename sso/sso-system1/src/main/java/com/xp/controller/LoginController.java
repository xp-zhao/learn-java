package com.xp.controller;

import com.alibaba.fastjson.JSONObject;
import com.xp.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xp-zhao on 2018/7/9.
 */
@Controller
@RequestMapping("/sso")
public class LoginController
{
	@RequestMapping (value = "/login.do",method= RequestMethod.GET)
	@ResponseBody
	public Object helloWorld(String username, String password,HttpServletRequest request,HttpSession session,HttpServletResponse response,Model model) throws IOException
	{
		JSONObject result = new JSONObject();
		String sessionId = request.getSession().getId();
		String sessionId1 = session.getId();
		System.out.println("sessionId:"+sessionId);
		if(StringUtils.isBlank(username) || StringUtils.isBlank(password)){
			result.put("code" , 0);
			result.put("msg" , "用户名密码不能为空");
			return result;
		}
		String lognUser = (String) RedisUtil.get(sessionId);
		if(StringUtils.isNotBlank(lognUser)){
			result.put("code" , 1);
			result.put("msg" , "当前登录用户：" + username);
			return result;
		}
		RedisUtil.setEx(sessionId , username, (long) 60);
		System.out.println("sessionId: "+sessionId);
		result.put("code" , 1);
		result.put("msg" , "登录成功");
		return result;
	}
}
