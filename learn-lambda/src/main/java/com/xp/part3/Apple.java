package com.xp.part3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by xp-zhao on 2018/11/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Apple
{
	/**
	 * 颜色
	 */
	private String color;
	private Integer weight;
}
