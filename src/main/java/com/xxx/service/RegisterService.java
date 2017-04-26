package com.xxx.service;

import com.xxx.util.Result;

/**
 * 注册服务
 * @author miao
 * @date 2017年4月24日
 */

public interface RegisterService {
	/**
	 * 注册
	 * @param username 用户名
	 * @param password 密码
	 * @return 注册结果
	 * @throws Exception
	 */
	Result register(String user_id,String username,String password,String phone,String email)throws Exception;

}
