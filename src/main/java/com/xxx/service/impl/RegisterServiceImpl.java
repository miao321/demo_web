package com.xxx.service.impl;

import com.xxx.bean.User;
import com.xxx.dao.UserDao;
import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.service.RegisterService;
import com.xxx.util.Result;

/**
 * 注册实现
 * @author miao
 * @date 2017年4月24日
 */

public class RegisterServiceImpl implements RegisterService {
	@Override
	public Result register(String user_id,String username,String password,String phone,String email)throws Exception{
		UserDao dao=new UserDaoImpl();
		User user=new User(user_id,username,password,phone,email);           //这里可能有问题
		Result result=dao.addUser(user);
		return result;
	}

}
