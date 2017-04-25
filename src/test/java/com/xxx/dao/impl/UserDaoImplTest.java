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
//	@Test
//	public void testAdd() throws Exception{
//		UserDao dao=new UserDaoImpl();
//		User user=new User();
//		user.setId("8");
//		user.setUsername("mao123");
//		user.setPassword("abc");
//		user.setPhone("12312312312");
//		user.setEmail("2312312");
//		dao.addUser(user);
//		//dao.addUser("miu","miao123","13559777411","771969163@qq.com");
//	}
//	
//	
//	@Test
	public void testDeleteById() throws Exception{
		
//		String uuid=UUID.randomUUID().toString();
//		User user=new User(uuid,"name");
//		userDao.addUser(user);
//		userDao.deleteById(uuid);
		
		String uuid=UUID.randomUUID().toString();
		UserDao dao=new UserDaoImpl();
		User user=new User(uuid,"username", "password", "phone", "email");
		System.out.println(uuid);
		dao.addUser(user);
		dao.deleteById(uuid);
		
		
	}
	
//	@Test
//	public void testDeleteByName() throws Exception{
//		UserDao dao=new UserDaoImpl();
//		dao.deleteByName("mao123");
//	}
	
//	@Test
//	public void testGetUser() throws Exception{
//		UserDao dao=new UserDaoImpl();
//		User user=dao.getUser("miao");
//		
//		
//	}
	
//	@Test
//	public void testSearchByName() throws Exception{
//		UserDao dao=new UserDaoImpl();
//		User user=dao.searchByName("zhangsan");
//		System.out.println("user="+user.getEmail());
//	}
	
	@Test
	public void testUpdateByName() throws Exception{
		UserDao dao=new UserDaoImpl();
		User user=new User();
		//String uuid=UUID.randomUUID().toString();
		user.setId("id");
		user.setUsername("miao");
		user.setPassword("sdac");
		user.setPhone("321");
		user.setEmail("43143");
		boolean b=dao.updateByName(user);
		System.out.println(b);
		
		
	}

}
