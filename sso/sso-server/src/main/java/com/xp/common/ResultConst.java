package com.xp.common;

/**
 * Created by xp-zhao on 2018/7/12.
 */
public enum ResultConst
{
	/**
	 * 失败
	 */
	FAILED("0", "failed"),

	/**
	 * 成功
	 */
	SUCCESS("1", "success"),

	// 登录成功
	LOGIN_SUCCESS("000000","登录成功"),
	// 登录失败
	LOGIN_FAILED("199991","用户名密码不能为空"),
	// 用户未登录
	USER_NOT_LOGIN("199992","无登录信息"),
	// 验证成功
	VERIFY_SUCCESS("000000","认证成功"),
	// 验证失败
	VERIFY_FAILED("199993","认证失败，请重新登录");

	public String code;

	public String message;

	ResultConst(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
