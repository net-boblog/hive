package com.hive.provider.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hive.dao.mapper.UserMapper;
import com.hive.model.User;
import com.hive.provider.IUserService;
@Service(value="userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User selectUserByPrimaryKey(int userId) {
		return userMapper.selectUserByPrimaryKey(userId);
	}
	@Override
	public String test(String key) {
		return key+"测试";
	}
}
