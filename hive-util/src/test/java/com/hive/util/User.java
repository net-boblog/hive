package com.hive.util;

import java.util.HashMap;
import java.util.Map;

public class User extends Man implements Person,Woman{
	private String name;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void play() {
		
		
	}
	public static void main(String[] args) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("","");
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	
}
