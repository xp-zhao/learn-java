package com.xp.common;

import com.xp.model.User;

import java.util.HashMap;

/**
 * Created by xp-zhao on 2018/7/12.
 */
public class LoginUserContext
{
	private static HashMap mymap = new HashMap();

	public static synchronized void addUser(String sessionId,User user) {
		if (sessionId != null) {
			mymap.put(sessionId, user);
		}
	}

	public static synchronized void delUser(String sessionId) {
		if (sessionId != null) {
			mymap.remove(sessionId);
		}
	}

	public static synchronized User getUser(String sessionId) {
		if (sessionId == null)
			return null;
		return (User) mymap.get(sessionId);
	}

	public static synchronized void delAll()
	{
		mymap.clear();
	}
}
