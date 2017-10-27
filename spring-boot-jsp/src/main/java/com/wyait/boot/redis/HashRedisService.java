package com.wyait.boot.redis;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public abstract class HashRedisService<T> {
	@Autowired
	protected RedisTemplate<String, Object> redisTemplate;
	@Resource
	protected HashOperations<String, String, T> hashOperations;

	/**
	 * 存入redis中的key
	 *
	 * @return
	 */
	private static String REDIS_KEY = "token:";

	/**
	 * 添加
	 *
	 * @param key    key
	 * @param doamin 对象
	 * @param expire 过期时间(单位:秒),传入 -1 时表示不设置过期时间
	 */
	public void put(String key, T doamin, long expire) {
		hashOperations.put(REDIS_KEY, key, doamin);
		if (expire != -1) {
			redisTemplate.expire(REDIS_KEY, expire, TimeUnit.SECONDS);
		}
	}

	/**
	 * 删除
	 *
	 * @param key 传入key的名称
	 */
	public void remove(String key) {
		hashOperations.delete(REDIS_KEY, key);
	}

	/**
	 * 查询
	 *
	 * @param key 查询的key
	 * @return
	 */
	public T get(String key) {
		return hashOperations.get(REDIS_KEY, key);
	}

	/**
	 * 获取当前redis库下所有对象
	 *
	 * @return
	 */
	public List<T> getAll() {
		return hashOperations.values(REDIS_KEY);
	}

	/**
	 * 查询查询当前redis库下所有key
	 *
	 * @return
	 */
	public Set<String> getKeys() {
		return hashOperations.keys(REDIS_KEY);
	}

	/**
	 * 判断key是否存在redis中
	 *
	 * @param key 传入key的名称
	 * @return
	 */
	public boolean isKeyExists(String key) {
		return hashOperations.hasKey(REDIS_KEY, key);
	}

	/**
	 * 查询当前key下缓存数量
	 *
	 * @return
	 */
	public long count() {
		return hashOperations.size(REDIS_KEY);
	}

	/**
	 * 清空redis
	 */
	public void empty() {
		Set<String> set = hashOperations.keys(REDIS_KEY);
		for (String key : set) {
			hashOperations.delete(REDIS_KEY, key);
		}
		// set.stream().forEach(key -> hashOperations.delete(REDIS_KEY,
		// key));//依赖jdk1.8
	}
}