package com.xxx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.bean.User;
import com.xxx.dao.UserDao;
import com.xxx.util.DBUtils;
import com.xxx.util.EncryptUtils;
import com.xxx.util.Result;

/**
 * 实现user的增删改查的操作
 * @author miao
 * @date 2017年4月23日
 */

public class UserDaoImpl implements UserDao {
	//日志记录
	private static final Logger logger=LoggerFactory.getLogger(UserDaoImpl.class);
	
	/**
	 * 每次请求都创建新的connection，这么做是不合理的，实际项目中都用数据库连接池
	 */
	private Connection connection=null;
	public UserDaoImpl() throws SQLException{
		connection=DBUtils.getConnection();
	}
	
	@Override
	public Result addUser(User user)throws Exception{
		//首先判断该用户是否已经存在
		User existedUser=getUser(user.getUsername());
		if(existedUser!=null){
			return new Result(false,"用户名已经存在");
		}
		
		User password=getUser(user.getPassword());
		User confirPassword=getUser(user.getConfirPassword());
		if(password!=confirPassword){
			return new Result(false,"两次密码不一样");
		}
//		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
//		User phone=getUser(user.getPhone());
//		//String existedPhone=(String)phone;
//		if(!phone.equals(regex)){
//			return new Result(false,"手机号不存在");
//		}
		
		String user_id=generateId();  //给user生成id
		
		PreparedStatement statement=connection.prepareStatement("insert into users(user_id,username,password,phone,email) values(?,?,?,?,?)");		
		statement.setString(1,user_id);
		statement.setString(2, user.getUsername());
		statement.setString(3, EncryptUtils.encript(user.getPassword())); //保存加密的密码
		statement.setString(4, user.getPhone());
		statement.setString(5, user.getEmail());
		statement.execute();  //执行sql语句
		
		if(statement.getUpdateCount()>0){
			User addedUser=new User(user_id,user.getUsername(),user.getPassword(),user.getPhone(),user.getEmail());
			logger.info("user added[{}]", addedUser);
			return new Result(true,"添加用户成功");
		}else{
			logger.warn("failed to add user[name={},password={}]", user.getUsername(),user.getPassword());
			
			return new Result(false,"添加用户失败");
		}
	}
	
	@Override
	public User getUser(String username)throws Exception{
		PreparedStatement statement=connection.prepareStatement("select * from users where username=?");
		statement.setString(1, username);
		ResultSet rs=statement.executeQuery();
		if(rs.next()){
			//查询到结果
			String id=rs.getString(1);
			String password=rs.getString(3);
			String phone=rs.getString(4);
			String email=rs.getString(5);
			User user=new User(id,username,password,phone,email);
			logger.info("get user[{}]",user);
			return user;
		}else{
			logger.info("failed to get user[name={}]", username);
			return null;
		}
	}
	
	@Override
	public boolean deleteById(String user_id)throws Exception{
		PreparedStatement statement=connection.prepareStatement("delete from users where user_id=?");
		statement.setString(1, user_id);
		statement.execute();
		boolean success=false;
		if(statement.getUpdateCount()>0){
			//删除成功
			logger.info("delete user[id={}]", user_id);
			success=true;
		}else{
			logger.warn("failed to delete user[id={}]", user_id);
			success=false;
		}
		return success;
	}
	
	@Override
	public boolean deleteByName(String username) throws Exception{
		PreparedStatement statement=connection.prepareStatement("delete from users where username=?");
		statement.setString(1,username);
		statement.execute();
		boolean success=false;
		if(statement.getUpdateCount()>0){
			//删除成功
			logger.info("delete user[name={}]", username);
			success=true;
		}else{
			logger.warn("failed to delete user[user={}]", username);
			success=false;
		}
		return success;
	}
	
	@Override
	public User searchByName(String username)throws Exception{
		PreparedStatement statement=connection.prepareStatement("select * from users where username=?");
		statement.setString(1, username);
		ResultSet rs=statement.executeQuery();
		if(rs.next()){
			//查询结果集
			String user_id=rs.getString(1);
			String password=rs.getString(3);
			String phone=rs.getString(4);
			String email=rs.getString(5);
			User user=new User(user_id,username,password,phone,email);
			logger.info("get user[{}]",user);
			return user;
		}else{
			logger.info("failed to get user[name={}]", username);
			return null;
		}
	}
	
	@Override
	public boolean updateByName(User user)throws Exception{
		//User existedUser=new User();
		PreparedStatement statement=connection.prepareStatement("UPDATE users set username='"+user.getUsername()
				+"',password='"+user.getPassword()+"',phone='"
				+user.getPhone()+"',email='"+user.getEmail()
				+"' WHERE username='"+user.getUsername() + "'");
//		statement.setString(1, user.getUsername());
		statement.executeUpdate();
		boolean success=false;
		if(statement.getUpdateCount()>0){
			//修改成功
			logger.info("update user[usrename={}]", user.getUsername());
			success=true;
		}else{
			logger.warn("failed to update user[username={}]", user.getUsername());
			success=false;
		}
		return success;
	}
	
	/**
	 * 生成随机串，在单机环境下唯一，实际项目中不能这么做
	 * @return
	 */
	private String generateId(){
		return UUID.randomUUID().toString();
	}
}
