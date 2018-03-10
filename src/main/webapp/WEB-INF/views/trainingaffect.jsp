<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">


</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统</title>
</head>
<scrpit src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js"></scrpit>
<script type="text/javascript" >
$('document').ready(function() {
	$("#classID").change(classidonchange);
});
function classidonchange() {
	var classID = $(this).val();
	$('#classID').val(classID);
	$.ajax({
		type : 'POST',
		url : "/Training/ajax/gettrainingclassinfo",
		data : {
			"classID" : classID
		},
		async : false,
		success : function(data) {
			initcontrol($('#registerform'), data);
		},
		fail : function() {
			alert("连接服务器失败！")
		}
	})
}
function initcontrol(control,data){
    for(var field in data){
    	if(field=='classID')
    		{
    		continue;
    		}
        if(control.find('#'+field).html()!=undefined)
        {   
            control.find('#'+field).html(data[field]);
        }
    }
}
</script>
<body>

	<div id="upcontent">欢迎！${userinfo.name}</div>
	<form action="${pageContext.request.contextPath}/trainingdiary/trainingaffect"
		method="POST">
		<div id="registerform">
			<div>
				<label>培训班名称:</label>
				 <select id="classID" name="classID" type="text">
				 				<option disabled selected value>请选择班级</option>
					<c:forEach var="info" items="${classnames}" varStatus="varStatus">
						<option value="${info.classID}">${info.className}</option>
					</c:forEach>
				</select>
				<div>
					<label>培训形式</label> <span id="trainingForm" name="trainingForm"
						>${classinfo.trainingForm}</span>
				</div>
				<div>
					<label>培训日期</label> <span id="trainingTime" name="trainingTime"
						>${input.trainingTime }</span>
						<label>结业日期</label> <input id="graduateDate" name="graduateDate"
						value="${input.graduateDate}"></input>
						 <label>培训学时</label> <span
						id="trainingPeriod" name="trainingPeriod" >${classinfo.trainingPeriod}</span>
				</div>
				<div>
					<label>培训人数</label> <span id="memberAmount" name="memberAmount"
						>${classinfo.memberAmount}</span>
						<label>结业人数</label> 
						<input id="graduateAmount" name="graduateAmount" 
						value="${input.graduateAmount}"></input>
						 <label>教师姓名</label> <span
						id="teacherName" name="teacherName" >${classinfo.teacherName}</span>
				</div>
				<div><div id="inputtittle">培训情况</div><input id="trainingState" name="trainingState" value="${input.trainingState}" type="text"/></div>
				<div><div id="inputtittle">培训效果评价</div><input id="affectComment" name="affectComment" value="${input.affectComment}" type="text"/></div>
				<div id="formbottom"> <div>负责人</div><input type="text" id="charge" name="charge" value="${input.charge}"/></div>
			</div>

			<div>${msg}</div>
			<input type="submit" value="提交"></input>

		</div>
	</form>
</body>
</html>