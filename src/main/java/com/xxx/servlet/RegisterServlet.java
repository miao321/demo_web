package com.xxx.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xxx.bean.User;
import com.xxx.service.LoginService;
import com.xxx.service.RegisterService;
import com.xxx.service.impl.RegisterServiceImpl;
import com.xxx.util.PathUtils;
import com.xxx.util.Result;

/**
 * 处理注册请求
 * @author miao
 * @date 2017年4月24日
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger=LoggerFactory.getLogger(RegisterServlet.class);
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//实现注册功能
		RegisterService registerService=null;
		Result result=null;
		//User user=new User();
		try{
			registerService=new RegisterServiceImpl();
			response.setContentType("text/html,charset=utf-8");
			//获取网页表单的内容
			String user_id=request.getParameter("user_id");
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String confirmPassword=request.getParameter("confirmPassword");
			String phone=request.getParameter("phone");
			String email=request.getParameter("email");
			String role=request.getParameter("role");
			result=registerService.register(user_id,username,password,phone,email,role);
		}catch(Exception e){
			//数据库连接创建失败
			logger.error("{}", e);
			//设置错误信息，以便error.jsp中显示
			request.setAttribute("error", new com.xxx.util.Error(e.getMessage(), e.getCause()));
			//跳转到全局错误处理页面error.jsp
			request.getRequestDispatcher(PathUtils.JSP_ERROR).forward(request, response);
		}
		
		if(result.isSuccess()){
			//request.setAttribute("username",registerService.);
			//注册成功，跳转到login.jsp
			request.getRequestDispatcher(PathUtils.JSP_LOGIN).forward(request, response);
		}else{
			request.setAttribute("result", result);
			request.getRequestDispatcher(PathUtils.JSP_REGISTER).forward(request, response);
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
