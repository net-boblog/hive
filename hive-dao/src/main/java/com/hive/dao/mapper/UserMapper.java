package com.hive.dao.mapper;

import com.hive.model.User;


public interface UserMapper{
	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
	User selectUserByPrimaryKey(int userId);
}
