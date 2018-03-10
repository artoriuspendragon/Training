<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>焊工培训系统</title>
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
<link
	href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"
	rel="stylesheet" />
<script src="/resource/commontools.js"></script>
<link rel="stylesheet" href="/resource/homepage.css">
<script>
$('document').ready(function () {
        $('form').bootstrapValidator({
　　　　　　　　message: 'This value is not valid',
            　feedbackIcons: {
                　　　　　　　　valid: 'glyphicon glyphicon-ok',
                　　　　　　　　invalid: 'glyphicon glyphicon-remove',
                　　　　　　　　validating: 'glyphicon glyphicon-refresh'
            　　　　　　　　   },
            fields: {
            	ClassName: {
                    message: '班级名名验证失败',
                    validators: {
                        notEmpty: {
                            message: '班级名名不能为空'
                        }
                    }
                },
                studyContent: {
                    validators: {
                        notEmpty: {
                            message: '学习内容不能为空'
                        }
                    }
                },
                trainingBook: {
                    validators: {
                        notEmpty: {
                            message: '培训教材不能为空'
                        }
                    }
                },
                trainingForm:{
                	validators:{
                		notEmpty:{
                			message:'培训形式不能为空'
                		}
                	}
                },
                trainingPeriod:{
                	validators:{
                		notEmpty:{
                			message:'培训学时不能为空'
                		}
                	}
                }
            }
        });
    });
</script>
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
				<li class="active">培训登记</li>
			</ol>

		</div>
	<div class="navbar-right ">
		<div class="navbar-text noselect" style="padding-right: 40px;"
			id="time"></div>
	</div>
	</nav>
	<div class="container" id="form-group" style="margin-bottom: 100px;">
		<form action="${pageContext.request.contextPath}/trainingregister"
			method="POST">
			<div class="form-group">
				<label>班级名</label> <input class="form-control" id="ClassName"
					name="ClassName" type="text" placeholder="班级名"> </input>
			</div>
			<div class="form-group">
				<label>培训学习内容</label> <input class="form-control" id="studyContent"
					name="studyContent" type="text" placeholder="培训学习内容</"> </input>
			</div class="form-group">
			<div class="form-group">
				<label>培训人数</label> <input class="form-control" id="memberAmount"
					name="memberAmount" type="number" placeholder="培训"> </input>
			</div>
			<div class="form-group">
				<label>培训教材</label> <input class="form-control" id="trainingBook"
					name="trainingBook" type="text" placeholder="培训教材"> </input>
			</div>
			<div class="form-group">
				<label>培训形式</label> <input class="form-control" id="trainingForm"
					name="trainingForm" type="text" placeholder="培训形式"> </input>
			</div>
			<div class="form-group">
				<label>培训学时</label> <input class="form-control" id="trainingPeriod"
					name="trainingPeriod" type="text" placeholder="培训学时"> </input>
			</div>
			<div class="form-group">
				<label>培训时间</label> <input class="form-control" id="trainingTime"
					name="trainingTime" type="text" placeholder="培训时间"> </input>
			</div>
			<div class="form-group">
				<label>培训地点</label> <input class="form-control"
					id="trainingLocation" name="trainingLocation" type="text"
					placeholder="培训地点"> </input>
			</div>
			<div class="form-group form-inline">
				<label>培训课程</label> <input class="form-control" id="trainingClass"
					name="trainingClass" type="text" placeholder="培训课程"> </input> <input
					class="form-control" id="trainingClass" name="trainingClass"
					type="text" placeholder="培训课程"> </input> <input
					class="form-control" id="trainingClass" name="trainingClass"
					type="text" placeholder="培训课程"> </input> <input
					class="form-control" id="trainingClass" name="trainingClass"
					type="text" placeholder="培训课程"> </input> <input
					class="form-control" id="trainingClass" name="trainingClass"
					type="text" placeholder="培训课程"> </input>
			</div>
			<div class="form-group form-inline">
				<label>教师姓名</label> <input class="form-control" id="teacherName"
					name="teacherName" type="text" placeholder="教师姓名"> </input> <input
					class="form-control" id="teacherName" name="teacherName"
					type="text" placeholder="教师姓名"> </input> <input
					class="form-control" id="teacherName" name="teacherName"
					type="text" placeholder="教师姓名"> </input> <input
					class="form-control" id="teacherName" name="teacherName"
					type="text" placeholder="教师姓名"> </input> <input
					class="form-control" id="teacherName" name="teacherName"
					type="text" placeholder="教师姓名"> </input>
			</div>
			<div class="form-group form-inline">
				<label>教师单位</label> <input class="form-control" id="teacherUnit"
					name="teacherUnit" type="text" placeholder="教师单位"> </input> <input
					class="form-control" id="teacherUnit" name="teacherUnit"
					type="text" placeholder="教师单位"> </input> <input
					class="form-control" id="teacherUnit" name="teacherUnit"
					type="text" placeholder="教师单位"> </input> <input
					class="form-control" id="teacherUnit" name="teacherUnit"
					type="text" placeholder="教师单位"> </input> <input
					class="form-control" id="teacherUnit" name="teacherUnit"
					type="text" placeholder="教师单位"> </input>
			</div>

			<div class="form-group traininggoalarea">
				<label class="atcenter">培训目的和要求</label>
				<div class="atcenter">
					<textarea class="form-control formtextarea" id="trainingGoal"
						name="trainingGoal" type="text" placeholder="培训目的和要求"
						style="width: 100%; min-height: 300px;"></textarea>
				</div>
			</div>
			<c:if test="${!empty msg}">
				<div class="alert alert-danger">${msg}</div>
			</c:if>
			<div style="text-align: center">
				<div
					style="display: inline-block; margin: 0 auto; float: none; width: 200px;">
					<input class="btn btn-default" type="submit" value="提交"
						style="width: 100%"></input>
				</div>
			</div>
			<input name="_csrf" type="hidden" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>