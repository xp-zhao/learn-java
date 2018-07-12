package com.xp.storage;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/7/12.
 */
public enum SessionStorage
{
	INSTANCE;

	private Map<String, HttpSession> map = new HashMap();

	private SessionStorage() {
	}

	public void set(String token, HttpSession session) {
		this.map.put(token, session);
	}

	public HttpSession get(String token) {
		return this.map.containsKey(token) ? (HttpSession)this.map.remove(token) : null;
	}

	public HttpSession getSession(String token) {
		return (HttpSession)this.map.get(token);
	}
}
