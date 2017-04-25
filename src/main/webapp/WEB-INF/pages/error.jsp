<%@ page import="com.xxx.util.Error" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    <%
    	Error error=(Error) request.getAttribute("error");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>error</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-6 col-sm-offset-3" style="color:red">
			<div>发生异常了</div><br>
			<div>原因：<%=error.getReason() %></div><br/>
			<div>异常信息：<%=error.getCause().toString() %></div>
		</div>
	</div>

</body>
</html>