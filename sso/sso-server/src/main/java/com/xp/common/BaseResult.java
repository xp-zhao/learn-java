package com.xp.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果类
 * Created by xp-zhao on 2018/1/10.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult
{
	/**
	 * 状态码
	 */

	public String code;
	/**
	 * 描述
	 */
	public String message;

	/**
	 * 数据结果集
	 */
	public Object data;
}
