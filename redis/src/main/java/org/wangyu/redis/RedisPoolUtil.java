package org.wangyu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtil {
	
	private static JedisPool jedispool;
	
	//因为只需要创建一次连接池仅仅需要一个连接对象,所有放在静态代码块里面
	/**
	 * 至于初始化类的时候的顺序，先是父类的静态代快，然后执行子类的静态代码块，然后是父类的非静态代码块和默认构造方法
	 * 然后子类的非静态代码块和默认构造方法，最后是是普通方法
	 */
	static 
	{	//创建连接池信息
		JedisPoolConfig PoolConfig = new JedisPoolConfig();
		PoolConfig.setMaxTotal(5);//最大连接数5
		PoolConfig.setMaxIdle(1);//最大空闲数1
		String host = "192.168.50.204";
		int port = 6379;
		jedispool = new JedisPool(PoolConfig,host,port);
	}
	
	public static Jedis getJedis() {
		Jedis jedis = jedispool.getResource();
		jedis.auth("123456");
		return jedis;
	}
	
	public static void  close(Jedis jedis) {
		jedis.close();
	}
	
	

}
