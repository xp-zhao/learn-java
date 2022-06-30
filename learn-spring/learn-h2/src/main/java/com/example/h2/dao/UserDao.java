package com.example.h2.dao;

import com.example.h2.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/6/30
 */
public interface UserDao {
  void insert(UserEntity item);

  UserEntity query(@Param("id") Integer id);
}
