package com.xp.ChainOfResponsibility;

import com.xp.ChainOfResponsibility.model.Request;
import com.xp.ChainOfResponsibility.model.RequestType;

/**
 * Created by xp-zhao on 2018/12/27.
 */
public class QueryHandler extends Handler
{
	public QueryHandler(Handler successor)
	{
		super(successor);
	}

	protected String handleRequest(Request request)
	{
		if(request.getType() == RequestType.QUERY){
			return request.getName() + " is handle by QueryHandler";
		}else if(successor != null){
			return successor.handleRequest(request);
		}
		return null;
	}
}
