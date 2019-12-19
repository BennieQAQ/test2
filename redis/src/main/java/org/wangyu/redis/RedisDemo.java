package org.wangyu.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * java端通过jedis来操作redis服务器
 * @author wangyu
 *
 */
public class RedisDemo {
	
	public static void main(String[] args) {
		//选择jedis(String host, int port)构造方法 ,这里的host是我linux的ip地址,命名:ifconfig查看当前ip
		String host = "192.168.50.204";
		int post = 6379;
		Jedis jedis = new Jedis(host, post);
		//访问redis密码
		jedis.auth("123456");
		//测试结果为pong则成功访问
		System.out.println(jedis.ping());
		
	}
	
	/**
	 * 测试字符串
	 */
	@Test
	public void t1() {
		Jedis jedis = new Jedis("192.168.50.204", 6379);
		jedis.auth("123456");
		jedis.set("name", "zhangsan");
		String name = jedis.get("name");
		System.out.println(name);
		//测试成功再返回redis里get一下能拿到说明ok
		jedis.close();
		
	}
	
	/**
	 * 模拟生产环境当redis中有我们需要的数据额,那么就从Redis中读取反之从数据库中读取
	 */
	@Test
	public void t2() {
		Jedis jedis = new Jedis("192.168.50.204", 6379);
		jedis.auth("123456");
		String key = "list";
		if(jedis.exists(key)) {
			String name = jedis.get(key);
			System.out.println("从Redis中获取的数据"+name);
		}else {
			//假设从数据库中取得的数据
			String name = "lisi";
			jedis.set(key, name);
			System.out.println("从数据库中查询的数据"+name);
		}
		jedis.close();
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



