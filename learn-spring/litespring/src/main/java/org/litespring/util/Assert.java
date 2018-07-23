package org.litespring.util;

/**
 * Created by xp-zhao on 2018/7/23.
 */
public abstract class Assert
{
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
