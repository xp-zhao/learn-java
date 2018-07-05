package com.xp.service.impl;

import com.xp.beans.System;
import com.xp.mapper.SystemMapper;
import com.xp.service.SystemService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统 服务实现类
 * </p>
 *
 * @author xp-zhao
 * @since 2018-07-05
 */
@Service
public class SystemServiceImpl extends ServiceImpl<SystemMapper, System> implements SystemService {

}
