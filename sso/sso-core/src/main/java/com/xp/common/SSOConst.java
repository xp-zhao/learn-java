package com.xp.common;

/**
 * Created by xp-zhao on 2018/7/12.
 */
public class SSOConst
{
	public static final String SSO_SERVER_URL = "http://{0}/sso-server/";
	public static final String SSO_SERVER_VERIFY_URL = "http://{0}/sso-server/sso/verify.do";
	public static final String GET_LOGIN_USERINFO = "http://{0}/sso-server/sso/getLoginUserInfo.do";
	public static final String IS_LOGIN = "isLogin";
	public static final String CLIENT_URL = "callbackURL";
	public static final String TOKEN = "token";
	public static final String SESSION_ID = "sessionId";
	public static final String LOGOUT_REQUEST = "logoutRequest";

	public SSOConst() {
	}
}
