package com.xp.service;

import com.xp.entity.User;

/**
 * Created by xp-zhao on 2018/1/25.
 */
public interface UserService
{
	User findUserByName(String userName);
}
