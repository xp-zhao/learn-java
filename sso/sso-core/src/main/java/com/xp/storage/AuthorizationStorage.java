package com.xp.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/5/14.
 */
public enum  AuthorizationStorage
{
	INSTANCE;
	private Map<String, ArrayList<String>> map = new HashMap<>();

	public void set(String token, String url) {
		if (!map.containsKey(token)) {
			ArrayList<String> list = new ArrayList<>();
			list.add(url);
			map.put(token, list);
			return;
		}
		map.get(token).add(url);
	}

	public List<String> get(String token)
	{
		return map.get(token);
	}

	public List<String> remove(String token) {
		if (map.containsKey(token)) {
			return map.remove(token);
		}
		return null;
	}
}
