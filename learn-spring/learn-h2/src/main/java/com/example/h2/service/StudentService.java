package com.example.h2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.h2.dao.StudentMapper;
import com.example.h2.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-4-3
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {}
