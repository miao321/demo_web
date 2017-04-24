package com.xxx.dao.impl;

import java.util.UUID;

import org.junit.Test;

import com.xxx.bean.User;
import com.xxx.dao.UserDao;

/**
 * 测试类
 * @author miao
 * @date 2017年4月24日
 */

public class UserDaoImplTest {
	@Test
	public void testAdd() throws Exception{
		UserDao dao=new UserDaoImpl();
		dao.addUser("miu","miao123","13559777411","771969163@qq.com");
	}
	
	
	@Test
	public void testDeleteById(String id) throws Exception{
	
		String uuid=UUID.randomUUID().toString();
		User user=new User(uuid,"name");
		Result.addUser(user);
		userDao.deleteById(uuid);

	}
	
//	@Test
//	public void testDeleteByName() throws Exception{
//		UserDao dao=new UserDaoImpl();
//		dao.deleteByName("wangwu");
//	}

}
