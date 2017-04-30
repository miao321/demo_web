<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xxx.util.Result" %>
	<%
		String path=request.getContextPath();
		String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		Result result=(Result) request.getAttribute("result");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="//cdn.bootcss.com/jquery/3.1.0/jquery.js"> </script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>
<script>
	//function check(){
		//var password=document.getElementById("password");
		//var confirmPassword=document.getElementById("confirmPassword");
		//var pass="^[a-zA-Z0-9]{6,16}$";
		//if(password.value!=confirmPassword.value){
		//	alert("两次密码不一样");
		//}
		//if(password!=pass){
		//	alert("密码格式不一样");
		//}
		
	//}
</script>
<title>注册</title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" style="background:#272727;color:white">
		<div class="container">
			<div class="row" style="font-size:20px;margin-top:10px;">
				<div class="col-sm-12">
					注册
				</div>
			</div>
		</div>
	</div>
	
	<div class="row" style="margin-top:100px;align:center">
		<div class="col-sm-offset-4 col-sm-4" style="background:#eee;width:500px;border-radius:8px;box-shadow:5px 5px 5px #333">
			<form action="RegisterServlet" method="post" class="form-horizontal" role="form" >
				<div class="form-group">
					<div class="col-sm-12" style="margin-top:15px;">
						<input type="text" name="username" class="form-control" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" name="password" id="password" class="form-control" placeholder="请输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="password" name="confirmPassword" id="confirmPassword" class="form-control" placeholder="请再次输入密码">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" name="phone" class="form-control" placeholder="请输入手机号">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<input type="text" name="email" class="form-control" placeholder="请输入邮箱">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-12">
						<button type="submit" class="btn btn-primary" class="form-control" style="width:100%" >注册</button>
					</div>
				</div>
				
				
				<!-- 注册 -->
				
				<!-- 判断是否有错误信息，有的话显示出来 -->
				<%
					if(result!=null){
				%>
				<div align="left" style="color:red">
					<%=result.getReason() %>
				</div>
				<%
					}
				%>
			</form>
		</div>
	</div>

</body>
</html>