package com.xxx.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 加密工具类
 * @author miao
 * @date 2017年4月23日
 */

public class EncryptUtils {
	private static final Logger logger=LoggerFactory.getLogger(EncryptUtils.class);
	private static final String ALG_MD5="md5";
	private static MessageDigest MD5=null;  //负责md5摘要的对象
	private static Base64.Encoder BASE64_ENCODER=null; //负责编码的对象
	
	static {
		try{
			MD5=MessageDigest.getInstance(ALG_MD5);
			BASE64_ENCODER=Base64.getEncoder();
		}catch(NoSuchAlgorithmException e){
			logger.error("{}",e);
		}
	}
	
	/**
	 * md5取摘要，再以BASE64编码
	 * @param clearText 要加密的字符串
	 * @return 加密后的字符串
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	public static String encript(String clearText)throws NoSuchAlgorithmException{
		if(MD5==null){
			throw new NoSuchAlgorithmException(ALG_MD5);
		}
		byte[] bytes=MD5.digest(clearText.getBytes());
		return new String(BASE64_ENCODER.encode(bytes));
	}

}
