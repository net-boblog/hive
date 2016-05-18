package com.hive.provider;

import com.hive.model.User;

public interface IUserService {
	User selectUserByPrimaryKey(int userId);
	
	String test(String key);
}
