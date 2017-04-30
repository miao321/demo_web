package com.xxx.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.bean.User;
import com.xxx.dao.UserDao;
import com.xxx.dao.impl.UserDaoImpl;
import com.xxx.service.LoginService;
import com.xxx.util.EncryptUtils;
import com.xxx.util.Result;



/**
 * 实现登录注销等功能
 * @author miao
 * @date 2017年4月18日
 */

public class LoginServiceImpl implements LoginService {
	private static final Logger logger=LoggerFactory.getLogger(LoginServiceImpl.class);
	public static final String LOGIN_KEY="LOGIN_USER_NAME";
	private HttpSession session; //http会话
	
	private UserDao userDao;
	
	public LoginServiceImpl(HttpSession session) throws SQLException{
		this.session=session;
		userDao=new UserDaoImpl();
	}
	@Override
	public Result login(String username, String password) throws Exception {
		// 检查参数是否合法
		if (username == null || password == null) {
			return new Result(false, "用户名或密码不能为空");
		}		
		User user = null;
		try {
			user = userDao.getUser(username);
		} catch (Exception e) {
			logger.error("{}", e);
		}
		if (user == null) { // 没有该用户
			return new Result(false, String.format("用户\"%s\"不存在", username));
		}
		if (!EncryptUtils.encript(password).equals(user.getPassword())) { // 密码错误
			return new Result(false, "密码错误");
		}
		session.setAttribute(LOGIN_KEY, user.getUsername()); // 注册
		return new Result(true, "成功登陆");
	}

	@Override
	public Result logout(){
		if(session.getAttribute(LOGIN_KEY)==null){
			return new Result(false,"未登录");
		}
		session.setAttribute(LOGIN_KEY, null); //注销
		return new Result(true,"成功注销");
	}
	
	@Override
	public boolean isLogined(){
		Object username=session.getAttribute(LOGIN_KEY);
		return username!=null&&!("".equals(username));
	}
	
	/*
	 * @see
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T loginName(){
		return (T) session.getAttribute(LOGIN_KEY);
	}

}

