<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统首页</title>
</head>
<body>

	<div id="upcontent">
		欢迎！${userinfo.name}
	</div>
	<span>
	    <div><a href="${pageContext.request.contextPath}/trainingdiary/lessonrecord">授课记录</a></div>
	</span>
	<span>
	    <div><a href="${pageContext.request.contextPath}/trainingdiary/trainingaffect">培训效果评价</a></div>
	</span>

</body>
</html>