package com.hive.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hive.model.User;
import com.hive.provider.IUserService;

public class ServiceTest extends TestBase{
	@Autowired
	private IUserService userService;
	@Test
	public void a(){
		Integer a= 0;
		User user=userService.selectUserByPrimaryKey(1,a);
		System.out.println(user.getName());
	}
}
