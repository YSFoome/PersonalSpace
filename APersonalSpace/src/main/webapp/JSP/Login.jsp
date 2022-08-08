<%@page import="JavaBean.GetAllUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人空间-登录</title>
<link rel=stylesheet type="text/css" href="${pageContext.request.contextPath }/CSS/LoginCss.css">
<%
GetAllUser getAllUser=new GetAllUser();
application.setAttribute("alluser", getAllUser.getUserInfos());
%>
</head>
<body>
<%
String bool=(String)request.getAttribute("bool");
if(bool==null){
	bool="";
}else{
	%>
	<script type="text/javascript">
		alert("登陆失败");
	</script>
	<%
}
%>
	<div class="login">
		<div class="left"></div>
		<div class="right">
			<form action="/APersonalSpace/LoginServlet" method="post">
				<h1>登录</h1>
				<input class="userinfo" type="text" placeholder="账号" name="userid"	 />
				<input class="userinfo" type="password" placeholder="密码" name="userpasswd" /> 
				<input class="submit" type="submit" value="登录" />
			</form>
			<div class="help">
				<a href="${pageContext.request.contextPath }/JSP/Register.jsp">注册账号</a> 
			</div>
		</div>
	</div>
</body>
</html>