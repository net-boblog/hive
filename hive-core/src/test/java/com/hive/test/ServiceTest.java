package com.hive.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hive.model.User;
import com.hive.provider.IUserService;

public class ServiceTest extends TestBase{
	@Autowired
	private IUserService userService;
	@Test
	public void selectUserByParmaryKey(){
		User user=userService.selectUserByPrimaryKey(1);
		System.out.println(user.getName());
	}
	
}
