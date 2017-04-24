package com.xxx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库相关工具类
 * @author miao
 * @date 2017年4月23日
 */

public class DBUtils {
	private static final Logger logger=LoggerFactory.getLogger(DBUtils.class);
	static{
		synchronized (DBUtils.class) {
			try{
				Class.forName(DBConstants.MYSQL_DRIVER_NAME); //加载mysql驱动类				
			}catch(Exception e){
				logger.error("exception was thrown while loading mysql driver,cause:{}",e);
			}			
		}
	}
	
	/**
	 * 获取一个新的数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DBConstants.URL, DBConstants.USER, DBConstants.PASSWORD);  //创建connection实例
	}

}
