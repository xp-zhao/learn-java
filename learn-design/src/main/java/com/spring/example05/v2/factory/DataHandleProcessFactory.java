package com.spring.example05.v2.factory;

import com.spring.example05.v2.context.UserDataContext;
import org.springframework.stereotype.Component;

/**
 * 数据处理流程工厂类
 *
 * @author zhaoxiaoping
 * @date 2024-8-7
 */
@Component
public class DataHandleProcessFactory extends AbstractProcessFactory<UserDataContext> {}
