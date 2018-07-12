package com.xp.feign;

import com.xp.model.User;
import feign.Headers;
import feign.RequestLine;

/**
 * Created by xp-zhao on 2018/6/27.
 */
public interface SSORemoteService
{
	/**
	 * 获取当前登录的用户信息
	 * @return
	 */
	@Headers ({"Content-Type: application/json","Accept: application/json"})
	@RequestLine ("POST /sso-server/sso/getUserInfo.do") User getLoginUser(String sessionId);
}
