package com.xp.common;

/**
 * Created by xp-zhao on 2018/7/12.
 */
public class AdminResult extends BaseResult
{
	public AdminResult(ResultConst resultConst,Object data){
		super(resultConst.code,resultConst.message,data);
	}

	public AdminResult(ResultConst resultConst)
	{
		super(resultConst.code,resultConst.message,null);
	}
}
