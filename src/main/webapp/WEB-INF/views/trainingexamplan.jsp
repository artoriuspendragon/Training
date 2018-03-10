<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<script
	src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"
	rel="stylesheet" />
<script src="/resource/commontools.js"></script>
<link rel="stylesheet" href="/resource/homepage.css" />
<script>
var trainingtrnumber=0;
var examtrnumber=0;
function trainingtrelement(number){
	const element=`<tr>
		<td><input  class="form-control"  id="trainingContent" name="trainingplanList[${'${'}number}].trainingContent"
		type="text" /></td>
	<td><input class="form-control"  id="startTime" name="trainingplanList[${'${'}number}].startTime" type="text" /></td>
	<td><input class="form-control"  id="endTime" name="trainingplanList[${'${'}number}].endTime" type="text" /></td>
	<td><input class="form-control"  id="teacher" name="trainingplanList[${'${'}number}].teacher" type="text" /></td>
	<td><input class="form-control"  id="remarks" name="trainingplanList[${'${'}number}].remarks" type="text" /></td>
</tr>`;
	return element;}

function examtrelement(number){
	const element=`<tr>
		<td><input class="form-control"  id="examItem" name="examplanList[${'${'}number}].examItem" type="text" /></td>
		<td><input class="form-control"  id="examdate" name="examplanList[${'${'}number}].examdate" type="text" /></td>
		<td><input class="form-control"  id="teacher" name="examplanList[${'${'}number}].teacher" type="text" /></td>
		<td><input class="form-control"  id="remarks" name="examplanList[${'${'}number}].remarks" type="text" /></td>
	</tr>`;
	return element;}

function addtrainingtrelement(){
	trainingtrnumber++;
	document.getElementById("trainingplantable").innerHTML+=trainingtrelement(trainingtrnumber);
	return false;
}
function addexamtrelement(){
	examtrnumber++;
	document.getElementById("examplantable").innerHTML+=examtrelement(examtrnumber);
	return false;
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统</title>
</head>
<body>

	<nav class="navbar navbar-default navbar-inverse">
	<div class="navbar-header">
		<div class="navbar-brand noselect">焊工培训系统</div>
	</div>
	<span class="navbar-text noselect" style="margin-right: 0;">欢迎！</span>
	<div class="nav navbar-nav">
	<div class="btn-group" id="dropdowngroup">

		<div class="navbar-text noselect  ">
			<span id="user"><span class=" glyphicon glyphicon-user "></span>${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.name}</span>

		</div>
		<ul class="dropdown-menu" style="margin-top: 0;">
			<li><a href="#">用户信息</a></li>
			<li><a href="#">密码修改</a></li>
			<li role="separator" class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
		</ul>
	</div>
	</div>
	<div class="navbar-text noselect  ">
		<ol class="breadcrumb"
			style="background-color: rgba(0, 0, 0, 0); margin: 0; padding: 0;">
			<li><a href="/Training/home">主页</a></li>
			<li class="active">考试计划</li>
		</ol>

	</div>
	<div class="navbar-right ">
		<div class="navbar-text noselect" style="padding-right: 40px;"
			id="time"></div>
	</div>
	</nav>
	<div id="registerform" class="container">
	<form action="${pageContext.request.contextPath}/trainingexamplan"
		method="POST">
		<div id="registerform">
			<div>
				<label>培训班名称:</label> <select id="classID" name="classID"
					type="text">
					<c:forEach var="info" items="${classnames}" varStatus="varStatus">
						<option value="${info.classID}">${info.className}</option>
					</c:forEach>
				</select>
				<div class="form-group">
					<label>培训考试单位</label> <input class="form-control"  id="unit" name="unit"
						value="${input.unit}"></input>
				</div>
				<div class="form-group">
					<label>培训人数</label> <input class="form-control"  id="memberAmount" name="memberAmount"
						value="${input.memberAmount}"></input>
				</div>
				<div class="form-group">
					<label>联系人</label> <input  class="form-control" id="contact" name="contact"
						value="${input.contact}"> </input> <label>联系电话</label> <input
						class="form-control"  id="telephone" name="telephone" value="${input.telephone}"></input>
				</div>
				<div>培训计划</div>
			</div>
			<div class="form-group">
				<table id="trainingplantable"><button id="addbutton" type="button" onClick="addtrainingtrelement();return false;">+++</button>
					<thead>
						<th>培训内容</th>
						<th>培训开始时间</th>
						<th>培训结束时间</th>
						<th>指导教师</th>
						<th>备注</th>
					</thead>
					<tr>
						<td><input class="form-control"  id="trainingContent" name="trainingplanList[0].trainingContent"
							type="text" /></td>
						<td><input class="form-control"  id="startTime" name="trainingplanList[0].startTime" type="text" /></td>
						<td><input class="form-control"  id="endTime" name="trainingplanList[0].endTime" type="text" /></td>
						<td><input  class="form-control" id="teacher" name="trainingplanList[0].teacher" type="text" /></td>
						<td><input class="form-control"  id="remarks" name="trainingplanList[0].remarks" type="text" /></td>
					</tr>
				</table>
			</div>
			<table id="examplantable"><button id="addbutton" type="button" onClick="addexamtrelement();return false;">+++</button>
					<thead>
						<th>考试项目</th>
						<th>考试时间</th>
						<th>指导教师</th>
						<th>备注</th>
					</thead>
					<tr>
						<td><input class="form-control"  id="examItem" name="examplanList[0].examItem" type="text" /></td>
						<td><input  class="form-control" id="examdate" name="examplanList[0].examdate" type="text" /></td>
						<td><input  class="form-control" id="teacher" name="examplanList[0].teacher" type="text" /></td>
						<td><input  class="form-control" id="remarks" name="examplanList[0].remarks" type="text" /></td>
					</tr>
				</table>
			<div>${msg}</div>
			<input type="submit" value="提交"></input>

		</div>
	</form>
	</div>
</body>
</html>