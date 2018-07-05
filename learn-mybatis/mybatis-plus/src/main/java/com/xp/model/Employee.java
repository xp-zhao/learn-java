package com.xp.model;

import lombok.Data;
import lombok.ToString;

/**
 * Created by xp-zhao on 2018/7/5.
 */
@Data
@ToString
public class Employee
{
	private Integer id ;
	private String lastName;
	private String email ;
	private Integer gender ;
	private Integer age ;
}
