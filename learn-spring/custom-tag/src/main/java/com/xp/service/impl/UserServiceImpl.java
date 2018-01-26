package com.xp.service.impl;

import com.xp.entity.User;
import com.xp.service.UserService;

/**
 * Created by xp-zhao on 2018/1/25.
 */
public class UserServiceImpl implements UserService
{
	@Override
	public User findUserByName(String userName)
	{
		return new User(userName,userName+".example.org");
	}
}
