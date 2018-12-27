package com.xp.ChainOfResponsibility;

import com.xp.ChainOfResponsibility.model.Request;

/**
 * Created by xp-zhao on 2018/12/27.
 */
public abstract class Handler
{
	protected Handler successor;

	public Handler(Handler successor){
		this.successor = successor;
	}

	public final String handle(Request request){
		StringBuffer sb = new StringBuffer("执行结果：");
		String result = handleRequest(request);
		if(result == null){
			sb.append("未找到对应的执行器");
		}else{
			sb.append(result);
		}
		return sb.toString();
	}

	protected abstract String handleRequest(Request request);
}
