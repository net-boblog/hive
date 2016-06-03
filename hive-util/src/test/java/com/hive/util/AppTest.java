package com.hive.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppTest {
	private AppTest(){
		
	}
	public static void main(String[] args) {
		Integer a=null;
		System.out.println(a==null);
	}
	static int a=1;
	/**
	 * 递归
	 * @param count
	 * @return
	 */
	public static int sum(int count){
		a++;
		System.out.println("a="+a);
		count+=2;
		System.out.println("count="+count);
		if(a>7){
			return count;
		}
		return sum(count);
	}
	/**
	 * 正则
	 */
	public static void match(){
		Pattern pattern=Pattern.compile("\\d{15}|\\d{17}([\\d]|[X])");
		Matcher matcher=pattern.matcher("山大啊140881198911270036打140881198911270036 sa");
		while(matcher.find()){
			 System.out.println(matcher.groupCount());  
             System.out.println(matcher.group());          
		}
	}
	
}
