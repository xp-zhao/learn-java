package com.example.data.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.data.dao.one.UserInfoOneMapper;
import com.example.data.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-4-24
 */
@Service
public class UserInfoOneService extends ServiceImpl<UserInfoOneMapper, UserInfo> {}
