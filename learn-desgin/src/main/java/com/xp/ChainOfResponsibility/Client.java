package com.xp.ChainOfResponsibility;

import com.xp.ChainOfResponsibility.model.Request;
import com.xp.ChainOfResponsibility.model.RequestType;

/**
 * Created by xp-zhao on 2018/12/27.
 */
public class Client
{
	public static void main(String[] args) {
		Handler createHandler = new CreateHandler(null);
		Handler deleteHandler = new DeleteHandler(createHandler);
		Handler updateHandler = new UpdateHandler(deleteHandler);
		Handler queryHandler = new QueryHandler(updateHandler);

		Request request = new Request(RequestType.CREATE , "create request");
//		Request request = new Request(RequestType.ERROR , "error request");

		System.out.println(queryHandler.handle(request));
	}
}
