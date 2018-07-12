package com.xp.controller;

import com.xp.common.AdminResult;
import com.xp.common.LoginUserContext;
import com.xp.common.ResultConst;
import com.xp.common.SSOConst;
import com.xp.model.User;
import com.xp.storage.SessionStorage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/sso")
public class ValidateController
{
	/**
	 * token 验证
	 * @param request
	 * @return
	 */
	@RequestMapping("/verify.do")
	@ResponseBody
	public Object verify(HttpServletRequest request) {
		String token = request.getParameter(SSOConst.TOKEN);
		String sessionId = request.getParameter(SSOConst.SESSION_ID);

		HttpSession session = SessionStorage.INSTANCE.getSession(token);
		if(session != null && session.getAttribute(SSOConst.IS_LOGIN) != null &&
			(boolean) session.getAttribute(SSOConst.IS_LOGIN) == true)
		{
			SessionStorage.INSTANCE.set(sessionId,session);
			LoginUserContext.addUser(sessionId , LoginUserContext.getUser(session.getId()));
			return new AdminResult(ResultConst.VERIFY_SUCCESS);
		}
		else
		{
			return new AdminResult(ResultConst.VERIFY_FAILED);
		}
	}

	@RequestMapping("isLogin")
	@ResponseBody
	public Object isLogin(HttpServletRequest request,@RequestParam String sessionId)
	{
		User user = LoginUserContext.getUser(sessionId);
		if(null != user)
		{
			return new AdminResult(ResultConst.VERIFY_SUCCESS);
		}
		return new AdminResult(ResultConst.VERIFY_FAILED);
	}
}
