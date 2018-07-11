package com.xp.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by xp-zhao on 2018/3/26.
 */
public class RedisUtil
{
//	private static RedisTemplate<Serializable, Object> redisTemplate = SpringUtils.getBean("redisTemplate");
	private static StringRedisTemplate redisTemplate = SpringUtils.getBean("redisTemplate");

	/**
	 * 批量删除对应的value
	 *
	 * @param keys
	 */
	public static void remove(final String... keys) {
		for (String key : keys) {
			remove(key);
		}
	}

	/**
	 * 批量删除key
	 *
	 * @param pattern
	 */
	public static void removePattern(final String pattern) {
		Set keys = redisTemplate.keys(pattern);
		if (keys.size() > 0)
			redisTemplate.delete(keys);
	}

	/**
	 * 删除对应的value
	 *
	 * @param key
	 */
	public static void remove(final String key) {
		if (exists(key)) {
			redisTemplate.delete(key);
		}
	}

	/**
	 * 判断缓存中是否有对应的value
	 *
	 * @param key
	 * @return
	 */
	public static boolean exists(final String key) {
		return redisTemplate.hasKey(key);
	}

	/**
	 * 读取缓存
	 *
	 * @param key
	 * @return
	 */
	public static Object get(final String key) {
		Object result;
		ValueOperations operations = redisTemplate
			.opsForValue();
		result = operations.get(key);
		return result;
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean set(final String key, Object value) {
		boolean result = false;
		try {
			ValueOperations operations = redisTemplate
				.opsForValue();
			operations.set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean hset(final String key, String field,Object value) {
		boolean result = false;
		try {
			HashOperations operations = redisTemplate.opsForHash();
			operations.put(key,field,value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Object hget(String key,String field)
	{
		HashOperations operations = redisTemplate.opsForHash();
		return operations.get(key,field);
	}


	public static Long hdel(String key,String field)
	{
		HashOperations operations = redisTemplate.opsForHash();
		return operations.delete(key,field);
	}

	/**
	 * 写入缓存
	 *
	 * @param key
	 * @param value
	 * @return
	 */
	public static boolean setEx(final String key, Object value, Long expireTime) {
		boolean result = false;
		try {
			ValueOperations operations = redisTemplate
				.opsForValue();
			operations.set(key, value);
			redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 将 key 中储存的数字值增一
	 * @param key
	 */
	public static void incr(final String key)
	{
		ValueOperations operations = redisTemplate.opsForValue();
		operations.increment(key,1);
	}

	/**
	 * 将 key 中储存的数字值减一
	 * @param key
	 */
	public static void decr(final String key)
	{
		ValueOperations operations = redisTemplate.opsForValue();
		operations.increment(key,-1);
	}

	public  void setRedisTemplate(
		StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
