<%@ page language="java" contentType="text/html; charset=UTF-8"
	language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统</title>
</head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script>
	$('document').ready(function() {
		$('#classname').val(${selectedclass});
		$('#classname').change(classnameonchange);
	});
	function classnameonchange() {
		var classID = $(this).val();
		$('#classID').val(classID);
		$.ajax({
			type : 'POST',
			url : "/Training/ajax/getlessonrecords",
			data : {
				"classID" : classID
			},
			async : false,
			success : function(data) {
				console.log(data);
				inittable($('#infotable'), data);
			},
			fail : function() {
				alert("连接服务器失败！")
			}
		})
	}
	function inittable(control, data) {
		if(data.length==0)
			{
			control.find('tbody').html("");
			}
		else{var newinfo;
		for(let info of data) {  
			   var newline='<tr><td>'+info.lessondate+'</td><td>'+info.lessonContent+'</td><td>'+info.time+'</td><td>'+info.lessonPeriod+'</td><td>'+info.teacherSign+'</td></tr>';
			   newinfo+=newline;
		}
		control.find('tbody').html(newinfo);}
	}
</script>
<body>

	<div id="upcontent">欢迎！${userinfo.name}</div>
	<select id="classname" >
		<option disabled selected value></option>
		<c:forEach var="singlename" items="${classnames}" varStatus="Status">
			<option value="${singlename.classID}">${singlename.className}</option>

		</c:forEach>
	</select>
	<div id="infomation">
		<table id="infotable">
			<thead>
				<tr>
					<th>日期</th>
					<th>授课内容</th>
					<th>时间</th>
					<th>学时</th>
					<th>教师签字</th>
				</tr>
			<thead>
			<tbody>
				<c:if test="${!empty lessonrecords}">
				<c:forEach var="info" items="${lessonrecords}" varStatus="varStatus">
					<tr>
						<td>${info.lessondate}</td>
						<td>${info.lessonContent}</td>
						<td>${info.time}</td>
						<td>${info.lessonPeriod}</td>
						<td>${info.teacherSign}</td>
					</tr>
				</c:forEach>
			</c:if>
			</tbody>
	
		</table>
	</div>
	<div id="registerform">
		<form
			action="${pageContext.request.contextPath}/trainingdiary/lessonrecord"
			method="POST">
			<input id="classID" name="classID" type="hidden" />
			<div>
				<label>日期</label> <input id="lessondate" name="lessondate"
					type="text" placeholder="日期" value="${input.lessondate}"> </input>
			</div>
			<div>
				<label>授课内容</label> <input id="lessonContent" name="lessonContent"
					type="text" placeholder="授课内容" value="${input.lessonContent}">
				</input>
			</div>
			<div>
				<label>时间</label> <input id="time" name="time" type="text"
					placeholder="time" value="${input.time}"> </input>
			</div>
			<div>
				<label>学时</label> <input id="lessonPeriod" name="lessonPeriod"
					type="text" placeholder="学时" value="${input.lessonPeriod}">
				</input>
			</div>
			<div>
				<label>教师签字</label> <input id="teacherSign" name="teacherSign"
					type="text" placeholder="教师签字" value="${input.teacherSign}">
				</input>
			</div>
			<div>${msg}</div>
			<input type="submit" value="提交"></input>
		</form>
	</div>
</body>
</html>