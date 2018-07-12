package com.xp.utils;

import com.xp.feign.SSORemoteService;
import com.xp.model.User;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

/**
 * Created by xp-zhao on 2018/7/12.
 */
public class SSOUtil{
	private static SSORemoteService ssoRemoteService = Feign.builder()
		.encoder(new JacksonEncoder())
		.decoder(new JacksonDecoder())
		.options(new Request.Options(1000, 3500))
		.retryer(new Retryer.Default(5000, 5000, 3))
		.target(SSORemoteService.class, "http://auth.sso.com:8083/");

	public static User getLoginUser(String sessionId){
		return ssoRemoteService.getLoginUser(sessionId);
	}
}
