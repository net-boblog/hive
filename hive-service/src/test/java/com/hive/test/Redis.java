package com.hive.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import redis.clients.jedis.JedisCluster;

import com.hive.common.SerializationUtil;

public class Redis extends TestBase {
	@Resource
	private JedisCluster jedis;

//	@Test
	public void addSet() {
		User user1 = new User("12345", "常少鹏", 99.9);
		User user2 = new User("12346", "王卓卓", 99.8);
		User user3 = new User("12347", "邹雨欣", 96.8);
		User user4 = new User("12348", "郑伟山", 98.8);
		User user5 = new User("12349", "李超杰", 99.6);
		User user6 = new User("12350", "董明明", 99.0);
		User user7 = new User("12351", "陈国峰", 100.0);
		User user8 = new User("12352", "楚晓丽", 99.6);
		Long count=0L;
		count+=jedis.zadd("page_rank".getBytes(), user1.getScore(), SerializationUtil.serialize(user1));
		count+=jedis.zadd("page_rank".getBytes(), user2.getScore(), SerializationUtil.serialize(user2));
		count+=jedis.zadd("page_rank".getBytes(), user3.getScore(), SerializationUtil.serialize(user3));
		count+=jedis.zadd("page_rank".getBytes(), user4.getScore(), SerializationUtil.serialize(user4));
		count+=jedis.zadd("page_rank".getBytes(), user5.getScore(), SerializationUtil.serialize(user5));
		count+=jedis.zadd("page_rank".getBytes(), user6.getScore(), SerializationUtil.serialize(user6));
		count+=jedis.zadd("page_rank".getBytes(), user7.getScore(), SerializationUtil.serialize(user7));
		count+=jedis.zadd("page_rank".getBytes(), user8.getScore(), SerializationUtil.serialize(user8));
		System.out.println("COUNT="+count);
		
		Set<byte[]> set = jedis.zrevrange("page_rank".getBytes(), 0, 9);  
        Iterator<byte[]> iter = set.iterator();  
        int i = 1;  
        List<User> list = new ArrayList<User>();  
        while(iter.hasNext()) {
            User user = (User) SerializationUtil.deserialize(iter.next());  
            user.setRank(i++);  
            list.add(user);  
        }  
        for(User user : list) {  
            System.out.println(user);
        }    
	}
//	@Test
	public void addHash(){
		jedis.hset("user", "id", "1000");
		jedis.hset("user", "name", "张三");
		jedis.hset("user", "score", "100.00");
		jedis.hset("user", "rank", "2");
		jedis.expire("user", 60);
		System.out.println(jedis.hgetAll("user"));
		jedis.hincrBy("user", "rank", 2);
		System.out.println(jedis.hgetAll("user"));
	}
//	@Test
	public void rankAdd(){	
		jedis.hsetnx("user:12345", "name", "常少鹏");
		jedis.hsetnx("user:12345", "score", "99.9");
		
		jedis.hsetnx("user:12348", "name", "郑伟山");
		jedis.hsetnx("user:12348", "score", "99.9");


		jedis.hsetnx("user:12346", "name", "王卓卓");
		jedis.hsetnx("user:12346", "score", "99.8");
		
		jedis.hsetnx("user:12347", "name", "邹雨欣");
		jedis.hsetnx("user:12347", "score", "96.8");

		
		Map<String, Double> map=new HashMap<String, Double>();
		map.put("user:12345", 99.9);
		map.put("user:12346", 99.8);
		map.put("user:12347", 96.8);
		map.put("user:12348", 99.9);
		jedis.zadd("page_rank", map);
		
		Set<String> set=jedis.zrevrange("page_rank", 0, 9);
		for(String str:set){
			System.out.println(jedis.hgetAll(str));
		}
	}
	@Test
	public void addList(){
		/*jedis.lpush("latest","1");
		jedis.lpush("latest","2");
		jedis.lpush("latest","4");
		jedis.lpush("latest","3");*/
		System.out.println(jedis.lrange("latest", 0, -1));
	}
}
