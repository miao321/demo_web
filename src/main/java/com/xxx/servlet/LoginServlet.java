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
import com.xxx.util.Result;

/**
 * 登录处理请求
 * @author miao
 * @date 2017年4月24日
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=LoggerFactory.getLogger(LoginServlet.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService loginService=null;
		Result result=null;
		try{
			loginService=new LoginServiceImpl(request.getSession());
			//获取网页表单的内容
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//尝试登陆
			result=loginService.login(username, password);
		}catch(Exception e){
			//数据库连接创建失败
			logger.error("{}",e);
			//设置错误信息，以便error.jsp中显示
			request.setAttribute("error", new com.xxx.util.Error(e.getMessage(), e.getCause()));
			//跳转到全局错误处理页面error.jsp
			request.getRequestDispatcher(PathUtils.JSP_ERROR).forward(request, response);
		}
		
		if(result.isSuccess()){
			//登录成功，跳转到index.jsp
//			request.getSession().setAttribute("result", result);
//			String role=result.g
			String username=request.getParameter("username");
			if("admin".equals(username)){
			request.setAttribute("username", loginService.loginName());  //获取登录的名字绑定到jsp上，好让jsp那边取出值显示
			request.getRequestDispatcher(PathUtils.JSP_BACKGROUND).forward(request, response);
			}else{
				request.setAttribute("username", loginService.loginName());  //获取登录的名字绑定到jsp上，好让jsp那边取出值显示
				request.getRequestDispatcher(PathUtils.JSP_INDEX).forward(request, response);
			}
		}else{
			request.setAttribute("result", result);//获取登录的名字绑定到jsp上，好让jsp那边取出值显示
			request.getRequestDispatcher(PathUtils.JSP_LOGIN).forward(request, response);
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
