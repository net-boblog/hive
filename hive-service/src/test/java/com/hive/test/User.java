package com.hive.test;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8453427772079365855L;
	private String id;//编号
	private String name;//姓名 
	private double score;//得分  
	private int rank;//排名  
	public User() {
		super();
	}
	public User(String id, String name, double score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", score=" + score
				+ ", rank=" + rank + "]";
	}
}
