package com.xxx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.service.LoginService;
import com.xxx.service.impl.LoginServiceImpl;
import com.xxx.util.PathUtils;
/**
 * 注销请求处理
 * @author miao
 * @date 2017年4月24日
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=LoggerFactory.getLogger(LogoutServlet.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			LoginService loginService=new LoginServiceImpl(request.getSession());
			//注销
			loginService.logout();
			//跳转到首页index.jsp
			request.getRequestDispatcher(PathUtils.SERVLET_INDEX).forward(request, response);
		}catch(Exception e){
			//数据库连接创建失败
			logger.error("error", new com.xxx.util.Error("数据库异常", e.getCause()));
			//跳转到全局错误处理页面error.jsp
			request.getRequestDispatcher(PathUtils.JSP_ERROR).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
