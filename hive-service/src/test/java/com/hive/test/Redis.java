package com.hive.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;

import redis.clients.jedis.JedisCluster;

import com.hive.common.SerializationUtil;

public class Redis extends TestBase {
	@Resource
	private JedisCluster jedis;

//	@Test
	public void rankAdd() {
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
	}
	@Test  
    public void gameRankShow() {  
        Set<byte[]> set = jedis.zrevrange("page_rank".getBytes(), 0, 9);  
        Iterator<byte[]> iter = set.iterator();  
        int i = 1;  
        List<User> list = new ArrayList<User>();  
        while(iter.hasNext()) {
            User user = (User) SerializationUtil.deserialize(iter.next());  
            user.setRank(i++);  
            list.add(user);  
        }  
        for(User user : list)   
            System.out.println(user);  
    }  
}
