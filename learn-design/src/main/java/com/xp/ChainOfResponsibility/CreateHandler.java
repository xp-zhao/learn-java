package com.xp.ChainOfResponsibility;

import com.xp.ChainOfResponsibility.model.Request;
import com.xp.ChainOfResponsibility.model.RequestType;

/**
 * Created by xp-zhao on 2018/12/27.
 */
public class CreateHandler extends Handler
{
	public CreateHandler(Handler successor)
	{
		super(successor);
	}

	protected String handleRequest(Request request)
	{
		if(request.getType() == RequestType.CREATE){
			return request.getName() + " is handle by CreateHandler";
		}else if(successor != null){
			return successor.handleRequest(request);
		}
		return null;
	}
}
