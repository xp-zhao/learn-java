package com.xp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by xp-zhao on 2018/1/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User
{
	private String userName;
	private String email;
}
