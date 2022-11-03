package com.example.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mp.entity.User;
import com.example.mp.mapper.UserMapper;
import com.example.mp.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2022-11-1
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}
