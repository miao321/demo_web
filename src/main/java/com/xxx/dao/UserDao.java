package com.xxx.dao;

import com.xxx.bean.User;
import com.xxx.util.Result;

/**
 * 定义user的增删改查操作，所有和数据库这种user的交换都由此类完成
 * @author miao
 * @date 2017年4月23日
 */

public interface UserDao {
	
	/**
	 * 新增user到数据库
	 * @param user 
	 * @return 新增成功的话返回新增的user，否则返回null
	 * @throws Exception
	 */
	Result addUser(User user)throws Exception;
	
	/**
	 * 根据username获取user
	 * @param username 指定的username
	 * @return 存在的话返回该user，否则返回null
	 * @throws Exception
	 */
	User getUser(String username)throws Exception;
	
	/**
	 * 删除指定的user
	 * @param id 要删除的user的id
	 * @return 是否删除成功
	 * @throws Exception
	 */
	boolean deleteById(String id) throws Exception;
	
	/**
	 * 删除指定名字的user
	 * @param username 要删除的user的username
	 * @return 是否删除成功
	 * @throws Exception
	 */
	boolean deleteByName(String username)throws Exception;
	
	/**
	 * 根据user的username查找用户
	 * @param username  要查找的user的username
	 * @return 是否查找成功
	 * @throws Exception
	 * 
	 */
	User searchByName(String username)throws Exception;
	
	/**
	 * 根据user的username修改用户信息
	 * @param username 要修改信息的用户username
	 * @return 是否修改成功
	 * @throws Exception
	 */
	boolean updateByName(User user)throws Exception;

}
