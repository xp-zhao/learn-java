package com.example.h2.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.h2.entity.Student;

import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2024-4-3
 */
public interface StudentMapper extends BaseMapper<Student> {
    List<Student> query();
}
