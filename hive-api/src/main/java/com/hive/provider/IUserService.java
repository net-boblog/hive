package com.hive.provider;

import com.hive.model.User;

public interface IUserService {
	User selectUserByPrimaryKey(Integer userId,Integer userState);
	
	String test(String key);
}
