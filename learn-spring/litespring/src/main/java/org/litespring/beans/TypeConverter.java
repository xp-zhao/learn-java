package org.litespring.beans;

import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Created by xp-zhao on 2018/10/3.
 */
public interface TypeConverter
{
	<T> T convertIfNecessary(Object value, Class<T> requiredType) throws TypeMismatchException;
}
