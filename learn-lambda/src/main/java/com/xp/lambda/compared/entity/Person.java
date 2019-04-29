package com.xp.lambda.compared.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description: 测试 model
 * @author: zhaoxp
 * @create: 2019/04/28
 **/
@Data
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}