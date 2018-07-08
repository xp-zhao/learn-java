package org.litespring.beans;

/**
 * Created by xp-zhao on 2018/7/8.
 */
public class BeansException extends RuntimeException
{
	public BeansException(String msg) {
		super(msg);	}

	public BeansException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
