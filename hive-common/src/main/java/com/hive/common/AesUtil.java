package com.hive.common;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AesUtil {
	private final static String IV="1234567890123456";
	/**
	 * 加密
	 * @param content
	 * @param key
	 * @return
	 */
	private static String encrypt(String content,String key){
		if(StringUtils.isEmpty(content) || StringUtils.isEmpty(key)){
			return null;
		}
		if(key.length()!=16){
			return null;
		}
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	        byte[] raw = key.getBytes("UTF-8");
	        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	        IvParameterSpec iv = new IvParameterSpec(IV.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
	        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
	        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}
	/**
	 * 解密
	 * @param content
	 * @param key
	 * @return
	 */
	private static String decrypt(String content,String key){
		try {
            byte[] raw = key.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(content);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
	}
	public static void main(String[] args) {
		String content="{\"userId\":\"dhsuifh2983rubvaijr0utefa\",\"name\":\"2131313131\"}";
		String key="1234567890123456";
		System.out.println("加密前的字符串:"+content);
		String encrypt=encrypt(content, key);
		System.out.println("加密后的字符串:"+encrypt);
		String decrypt=decrypt(encrypt, key);
		System.out.println("解密后的字符串："+decrypt);
	}
}

