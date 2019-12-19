package org.wangyu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	
	public static void main(String[] args) {
		//创建redisPool基本信息
		JedisPoolConfig PoolConfig = new JedisPoolConfig();
		PoolConfig.setMaxTotal(5);//最大连接数5
		PoolConfig.setMaxIdle(1);//最大空闲数1
		//....
		//连接池对象
		String host = "192.168.50.204";
		int port = 6379;
		JedisPool jedispool = new JedisPool(PoolConfig, host,port);
		
		//获得jedis对象
		Jedis jedis = jedispool.getResource();
		jedis.auth("123456");
		System.out.println(jedis.ping());
		
		
		
	}

}
