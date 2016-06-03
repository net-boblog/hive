package com.hive.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.hive.model.User;


public interface UserMapper{
	/**
	 * 获取用户信息
	 * @param userId
	 * @return
	 */
	User selectUserByPrimaryKey(@Param("userId") Integer userId,@Param("userState") Integer userState);
}
