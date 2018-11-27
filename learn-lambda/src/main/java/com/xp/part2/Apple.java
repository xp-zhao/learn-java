package com.xp.part2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by xp-zhao on 2018/11/26.
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
	private int weight;
}
