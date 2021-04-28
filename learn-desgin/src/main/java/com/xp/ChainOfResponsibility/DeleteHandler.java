package com.xp.ChainOfResponsibility;

import com.xp.ChainOfResponsibility.model.Request;
import com.xp.ChainOfResponsibility.model.RequestType;

/**
 * Created by xp-zhao on 2018/12/27.
 */
public class DeleteHandler extends Handler
{
	public DeleteHandler(Handler successor)
	{
		super(successor);
	}

	protected String handleRequest(Request request)
	{
		if(request.getType() == RequestType.DELETE){
			return request.getName() + " is handle by DeleteHandler";
		}else if(successor != null){
			return successor.handleRequest(request);
		}
		return null;
	}
}
