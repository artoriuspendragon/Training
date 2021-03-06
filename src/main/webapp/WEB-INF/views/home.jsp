<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统首页</title>
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
<link rel="stylesheet" href="/resource/homepage.css">
<script type="text/javascript">
	function openclassdetail(event) {
		console.log($(event).find('#classID').html());
	}
	$('document').ready(function(){
	
	});
</script>
</head>
<body>

	<nav class="navbar navbar-default navbar-inverse">
	<div class="navbar-header">
		<div class="navbar-brand noselect">焊工培训系统</div>
	</div>
	<span class="navbar-text noselect" style="margin-right:0;">欢迎！</span>
	<div class="btn-group" id="dropdowngroup">
	
	<div  class="navbar-text noselect  " >
		 <span id="user" ><span class=" glyphicon glyphicon-user "></span>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}</span>
		
		</div>
		<ul class="dropdown-menu" style="margin-top:0;" >
			<li><a href="#">用户信息</a></li>
			<li><a href="#">密码修改</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
			</ul>
		</div>
	<div class="navbar-right " >
	<div class="navbar-text noselect" style="padding-right:40px;" id="time"></div>
	</div>
	</nav>
		 
	<div class="container">
		<div class="row">
			<a href="${pageContext.request.contextPath}/trainingregister">
				<div class="optioncircle ">
					<span class="optionshade"></span>
					<div class="option">培训登记</div>
				</div>
			</a> <a href="${pageContext.request.contextPath}/studentregister">
				<div class="optioncircle ">
					<span class="optionshade"></span>
					<div class="option">学员登记</div>
				</div>
			</a> <a href="${pageContext.request.contextPath}/trainingexamplan">
				<div class="optioncircle">
					<span class="optionshade"></span>
					<div class="option">考试计划</div>
				</div>
			</a>
		</div>
		<div class="row">
			<a href="${pageContext.request.contextPath}/approve">
				<div class="optioncircle">
					<span class="optionshade"></span>
					<div class="option">计划审批</div>
				</div>
			</a> <a href="${pageContext.request.contextPath}/trainingdiary">
				<div class="optioncircle">
					<span class="optionshade"></span>
					<div class="option">培训日记</div>
				</div>
			</a>
		</div>
	</div>
	<div class="divider"></div>
	<div class="container distancetop">
		<div class="tabletitle noselect">培训信息汇总表</div>
		<table id="classinfotable" class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>序号</th>
					<th>培训班名称</th>
					<th>培训时间</th>
					<th>学员人数</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="info" varStatus="Status" items="${classinfos}">
					<tr onclick="openclassdetail(this)">
						<td id="classID">${info.classID}</td>
						<td id="className">${info.className}</td>
						<td id="trainingTime">${info.trainingTime }</td>
						<td id="memberAmount">${info.memberAmount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>