package org.wangyu.redis;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class TestRedisPool {
	
	@Before
	public void before() {
		RedisPoolUtil redisPoolUtil = new RedisPoolUtil();
	}
	
	
	@Test
	public void t1() {
		Jedis jedis = RedisPoolUtil.getJedis();
		System.out.println(jedis.ping());
		RedisPoolUtil.close(jedis);
	}

}
