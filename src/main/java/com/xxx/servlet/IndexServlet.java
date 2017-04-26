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
 * 首页请求处理
 * @author miao
 * @date 2017年4月24日
 */

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger=LoggerFactory.getLogger(IndexServlet.class);   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			LoginService loginService=new LoginServiceImpl(request.getSession());
			//还没登录，跳转到登录页面
			if(!loginService.isLogined()){
				request.getRequestDispatcher(PathUtils.JSP_LOGIN).forward(request, response);
				return;
			}
			
			//已经登录，跳转到index.jsp
			request.setAttribute("username", loginService.loginName());
			request.getRequestDispatcher(PathUtils.JSP_INDEX).forward(request, response);
			
		}catch(Exception e){
			//数据库连接创建失败
			logger.error("{}",e);
			//设置错误信息，以便error。jsp中显示
			request.setAttribute("error", new com.xxx.util.Error("数据库异常",e));
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
