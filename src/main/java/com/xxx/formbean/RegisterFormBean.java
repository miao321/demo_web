package com.xxx.formbean;

import com.xxx.util.Result;

/**
 * 封装的用户注册表单bean，用来接收register.jsp中的表单输入项的值
 * RegisterFormBean中的属性与register.jsp中的表单输入项的name--对应
 * RegisterFormBean的职能除了负责接收register.jsp中的表单输入项的值之外还负责校对
 * @author miao
 * @date 2017年4月28日
 */

public class RegisterFormBean {
	private String username;
	private String password;
	private String confirmPassword;
	private String phone;
	private String email;
	
//	private Map<String,String> error=new HashMap<String,String>();
//	public Map<String,String> getErrors(){
//		return error;
//	}
	
	public Result validate(){
		boolean isOk=true;
		if(this.username==null||this.username.trim().equals("")){
			isOk=false;
			return new Result(false,"用户名不能为空！");
		}
		return null;
	}

}
