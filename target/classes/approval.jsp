<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></script>
<script src="/resource/commontools.js"></script>
<script>
	$('document').ready(function() {
		addbutton();
		$("#classID").change(classidonchange);
	});
	function classidonchange() {
		var classid = $(this).val();
		$.ajax({
			type : 'POST',
			url : "/Training/ajax/getclassinfo",
			data : {
				"classID" : $("#classID").val(),
				"${_csrf.parameterName}": "${_csrf.token}"
			},
			async : false,
			success : function(data) {
				initcontrol($('#baseinfo'),data);
			}

		});
	}
	function addbutton() {
		$("#approvebutton").click(function() {

			var postform = document.createElement("form");
			postform.actoin = "studentregister";
			postform.method = "post";
			var inputID = document.createElement("input");
			inputID.setAttribute("name", "classId");
			inputID.setAttribute("value", $("#classID").val());
			$("#classID").val()
			console.log(inputID);
			postform.appendChild(inputID);
			document.body.appendChild(postform);
			postform.submit();
		});
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统</title>
</head>
<body>

	<div id="upcontent">欢迎！${userinfo.name}</div>

	<label>培训班名称:</label>
	<select id="classID" name="classID" type="text" >
	<option disabled selected value></option>
		<c:forEach var="info" items="${classnames}" varStatus="varStatus">
			<option value="${info.classID}">${info.className}</option>
		</c:forEach>
	</select>
	<div id="classinfo">
		<div id="baseinfo">

			<div>
				<label>培训考试单位</label>
				<div id="unit" name="unit">${classinfo.unit}</div>
			</div>
			<div>
				<label>培训人数</label>
				<div id="memberAmount" name="memberAmount">${classinfo.memberAmount}</div>
			</div>
			<div>
				<label>联系人</label>
				<div id="contact" name="contact">${classinfo.contact}</div>
				<label>联系电话</label>
				<div id="telephone" name="telephone">${classinfo.telephone}</div>
			</div>

		</div>
		<c:if test="${!empty trainingplans}">
			<div>
				<div>培训计划</div>
				<table id="trainingplantable">
					<thead>
						<th>培训内容</th>
						<th>培训开始时间</th>
						<th>培训结束时间</th>
						<th>指导教师</th>
						<th>备注</th>
					</thead>
					<c:forEach var="trainingplan" items="${trainingplans}"
						varStatus="status">
						<tr>
							<td id="trainingContent${status}">
								${trainingplan.trainingContent}</td>
							<td id="startTime${status}">${trainingplan.startTime}</td>
							<td id="endTime${status}">${trainingplan.endTime}</td>
							<td id="teacher"${status}" >${trainingplan.teacher}</td>
							<td id="remarks${status}">${trainingplan.remarks}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</c:if>
		<c:if test="${!empty  examplans}">
			<table id="examplantable">
				<thead>
					<th>考试项目</th>
					<th>考试时间</th>
					<th>指导教师</th>
					<th>备注</th>
				</thead>
				<c:forEach var="examplan" items="${examplans}" varStatus="status">
					<tr>
						<td id="examItem${status}">${examplan.examItem}</td>
						<td id="examdate${status}">${examplan.examdate}</td>
						<td id="teacher${status}">${examplan.teacher}</td>
						<td id="remarks${status}">${examplan.remarks}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<div>${msg}</div>
		<button id="approvebutton">通过</button>
	</div>
</body>
</html>