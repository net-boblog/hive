package com.hive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hive.model.User;
import com.hive.provider.IUserService;

@Controller()
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private IUserService userService;
	@ResponseBody
	@RequestMapping(value="test")
	public String test(){
		return userService.test("返回结果");
	}
	@ResponseBody
	@RequestMapping(value="selectUser")
	public User selectUserParmaryKey(){
		User user=userService.selectUserByPrimaryKey(1, 0);
		System.out.println("Name:"+user.getName());
		return user;
	}
}
