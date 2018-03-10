<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
<script
	src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css"
	rel="stylesheet" />
	<script src="/resource/commontools.js"></script>
<link rel="stylesheet" href="/resource/homepage.css"/>
	<script>
$('document').ready(function(){
	$('form').bootstrapValidator({
　　　　　　　　message: 'This value is not valid',
            　feedbackIcons: {
                　　　　　　　　valid: 'glyphicon glyphicon-ok',
                　　　　　　　　invalid: 'glyphicon glyphicon-remove',
                　　　　　　　　validating: 'glyphicon glyphicon-refresh'
            　　　　　　　　   },
            fields: {
            	name: {
                    message: '学生姓名验证失败',
                    validators: {
                        notEmpty: {
                            message: '学生姓名不能为空'
                        }
                    }
                },
                sex: {
                    validators: {
                        notEmpty: {
                            message: '性别不能为空'
                        }
                    }
                },
                identity: {
                    validators: {
                        notEmpty: {
                            message: '身份证不能为空'
                        }
                    }
                },
                education:{
                	validators:{
                		notEmpty:{
                			message:'教育程度不能为空'
                		}
                	}
                },
                unit:{
                	validators:{
                		notEmpty:{
                			message:'单位不能为空'
                		}
                	}
                },
                certification:{
                	validators:{
                		notEmpty:{
                			message:'证书不能为空'
                		}
                	}
                },
                examType:{
                	validators:{
                		notEmpty:{
                			message:'考试类别不能为空'
                		}
                	}
                },
                examDegree:{
                	validators:{
                		notEmpty:{
                			message:'考试等级不能为空'
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
			<li><a href="/Training/studentregister">学生登记</a></li>
			<li class="active">学生修改</li>
		</ol>

	</div>
	<div class="navbar-right ">
		<div class="navbar-text noselect" style="padding-right: 40px;"
			id="time"></div>
	</div>
	</nav>
	<div id="registerform" class="container">
		<form id="editform"
			action="/Training/studentedit" method="POST"
			 margin-bottom: 100px;">
			<div class="form-group">
				<label>姓名</label> <input class="form-control" id="name" name="name"
					type="text" placeholder="姓名" value="${input.name}"> </input>
			</div>
			<div class="form-group">
				<label>性别</label> <select class="form-control" id="sex" name="sex"
					type="text" placeholder="性别" value="${input.sex}">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
			<div class="form-group">
				<label>年龄</label> <input class="form-control" id="age" name="age"
					type="number" placeholder="年龄" value="${input.age}"> </input>
			</div>
			<div class="form-group">
				<label>身份证</label> <input class="form-control" id="identity"
					name="identity" type="text" placeholder="身份证"
					value="${input.identity}"> </input>
			</div>
			<div class="form-group">
				<label>文化程度</label> <input class="form-control" id="education"
					name="education" type="text" placeholder="文化程度"
					value="${input.education}"> </input>
			</div>
			<div class="form-group">
				<label>单位</label> <input class="form-control" id="unit" name="unit"
					type="text" placeholder="单位" value="${input.unit}"> </input>
			</div>
			<div class="form-group">
				<label>现有合格证书</label> <input class="form-control" id="certification"
					name="certification" type="text" placeholder="现有合格证书"
					value="${input.certification}"> </input>
			</div>
			<div class="form-group">
				<label>培训考试类别</label> <input class="form-control" id="examType"
					name="examType" type="text" placeholder="培训地点"
					value="${input.examType}"> </input>
			</div>
			<div class="form-group">
				<label>培训考试等级</label> <input class="form-control" id="examDegree"
					name="examDegree" type="text" placeholder="培训考试等级"
					value="${input.examDegree}"> </input>
			</div>
			<div class="form-group">
				<label>备注</label> <input class="form-control" id="remarks"
					name="remarks" type="text" placeholder="备注"
					value="${input.remarks}"> </input>
			</div>
			<input name="studentID" type="hidden" value="${input.studentID}" />
			<input name="_csrf" type="hidden" value="${_csrf.token}" />
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
		</form>
	</div>
</body>
</html>