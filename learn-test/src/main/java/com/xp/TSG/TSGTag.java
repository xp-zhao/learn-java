package com.xp.TSG;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by xp-zhao on 2018/5/24.
 */
@Data
@AllArgsConstructor
public class TSGTag
{
	//	标签 id
	private String tag_id;
	//	标签名称
	private String tag_name;
	//	标签状态
	private int    status;
}
