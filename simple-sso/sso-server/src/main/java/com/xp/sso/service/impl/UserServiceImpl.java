package com.xp.sso.service.impl;

import com.xp.sso.dao.UserDao;
import com.xp.sso.entity.User;
import com.xp.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xp-zhao on 2018/1/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao;

	public User find(User user)
	{
		return userDao.find(user);
	}
}
