<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工系统登录页面</title>
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<script src="/resource/commontools.js"></script>
<script>
$('document').ready(function(){
	$('#loginform').fadeIn();
});
</script>
<link rel="stylesheet" href="/resource/loginpage.css">
</head>
<body style="text-align: center;">
	<div class="container">

		<div class="form row">

			<div class="centerform" style="display:none;" id="loginform">
				
				<form name='f' action='${pageContext.request.contextPath}/slogin'
					method='POST'>
					<div class="centertitle">焊工培训系统</div>
					<div class="input-group" style= "padding-bottom:20px;">
						<span class="input-group-addon">用户名</span> <input type='text'
							name='username' class="form-control" />
					</div>
					<div class=" input-group"  style= "padding-bottom:20px;">
						<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;码</span> <input type='password'
							name='password' class="form-control" />
					</div>
					<c:if test="${!empty loginerror}">
					<div class="alert alert-danger formlabel" >${loginerror}</div>
					</c:if>
					
					
					<div class=" col-lg-12"  style= "padding-bottom:20px;">
						<span><input name="submit" type="submit" value="登录" class="btn btn-default"/></span> <span>
						<input
							name="reset" type="reset" value="重置" class="btn btn-default"/></span>
					</div>
					
					<input name="_csrf" type="hidden" value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>