package com.xp.model;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * Created by xp-zhao on 2018/5/24.
 */
@Data
public class TSGResult
{
//	状态码
	private String     code;
//	提示信息
	private String     message;
//	流水号
	private String     requestId;
//	返回结果
	private String result;
}
