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


<title>登录</title>
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" style="background:#272727;color:white" >
		<div class="container">
			<div class="row" style="font-size:20px;margin-top:10px;">
				<div class="col-sm-12">
					登录
				</div>
			</div>
		</div>
	</div>
	
	<div class="row" style="margin-top:100px;align:center;">
		<div class="col-sm-offset-4 col-sm-4" style="background:#eee;width:500px;border-radius:8px;box-shadow:5px 5px 5px #333">
			<form action="LoginServlet" method="post" role="form">
				<div class="form-group" style="margin-top:15px">
					<div class="col-sm-12">
						<input type="text" name="username" class="form-control" placeholder="请输入用户名">
					</div>
				</div>
				<div class="form-group" >
					<div class="col-sm-12" style="margin-top:15px">
						<input type="password" name="password" class="form-control" placeholder="请输入密码">
					</div>				
				</div>
				<div class="form-group">
					<div class="col-sm-12" style="margin-top:15px">
						<button type="submit" class="btn btn-primary" class="form-control" style="width:100%">登录</button>
					</div>
				</div>
				
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
			<!-- 注册 -->
				<div class="col-sm-12" style="margin-top:15px;margin-bottom:15px">
					<a href="RegisterUIServlet" type="button" class="btn btn-primary form-horizontal" style="width:100%">注册</a>
				</div>
		</div>
	</div>

</body>
</html>