package com.xp.ChainOfResponsibility.model;

/**
 * Created by xp-zhao on 2018/12/27.
 */
public class Request
{
	private RequestType type;
	private String name;

	public Request(RequestType type, String name) {
		this.type = type;
		this.name = name;
	}

	public RequestType getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}
