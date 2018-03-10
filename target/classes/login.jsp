<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统</title>
</head>
<body>

	<div id="loginform" >
		<form  action="${pageContext.request.contextPath}/login" method="POST">
			<div>
			  <label>请输入用户名</label>
			  <input id="loginID" name="loginID" type="ID" placeholder="密码">
			  </input>
			</div>
			<div>
			  <label>请输入密码</label>
			  <input id="loginPwd" name="loginPwd" type="password" placeholder="密码">
			  </input>
			</div>
			<div>
			  ${msg}
			</div>
			<input type="submit" value="提交"></input>
		</form>
	</div>
</body>
</html>