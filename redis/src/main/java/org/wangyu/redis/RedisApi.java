package org.wangyu.redis;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisApi {
	
	private Jedis jedis;
	
	@Before
	public void before() {
		RedisPoolUtil redisPoolUtil = new RedisPoolUtil();
		jedis = redisPoolUtil.getJedis();
	}
	
	/**
	 * 判断某个某个键值对是否存在
	 */
	@Test
	public void Exists() {
		if(jedis.exists("name")) {
			System.out.println("该键值已经存在");
		}else {
			System.out.println("该键值已经不存在");
		}
	}
	
	/**
	 * jedis.append(String key,String value)方法，如果键值存，那么在这个键值之后值得末尾添加value值，如果没有就等同于set key value
	 *  返回值是一个Long类型的字符数
	 */
	@Test
	public void test2 () {
		Long jedislong = jedis.append("gender", "123");
		System.out.println(jedislong);
	}
	
	@Test
	public void test3() {
		Long lpush = jedis.lpush("score", "1,2,3,4,5,6");
		//遍历组合
		List<String> list = jedis.lrange("score", 0, -1);
		for(String element:list) {
			System.out.print(element);
		}
		
	}
	
	/**
	 *  返回存储在指定键处的列表的长度。
	 */
	
	@Test
	public void test4() {
		Long length = jedis.llen("score");
		System.out.println(length);
	}
	
	/**
	 * 
	 */
	@Test
	public void test5() {
		
	}
	
	


}











