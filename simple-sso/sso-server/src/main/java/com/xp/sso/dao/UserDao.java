package com.xp.sso.dao;

import com.xp.sso.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao
{
	User find(@Param ("user") User user);
}
