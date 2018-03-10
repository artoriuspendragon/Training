<%@ page language="java" contentType="text/html; charset=UTF-8"
	language="java" pageEncoding="UTF-8"%>
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
<script type="text/javascript">
$('document').ready(function(){
	$('#infotable').bootstrapTable({
		
	     url:"${pageContext.request.contextPath}/ajax/getstudentsinfo",
	     method: 'get',   
	     toolbar:$('#toolbar'),
		 pagination: false,
		 
		   columns: [{
               checkbox: true
           }, {
               field: 'studentID',
               title: '序号',
            	   sortable : true
           }, {
               field: 'name',
               title: '姓名',
            	   sortable : true
           }, {
               field: 'sex',
               title: '性别'
           }, {
               field: 'identity',
               title: '身份证号'
           }, 
           {
               field: 'education',
               title: '文化程度',
           }, 
           {
               field: 'unit',
               title: '单位'
           }, 
           {
               field: 'certification',
               title: '现有合格证书'
           }, 
           {
               field: 'examType',
               title: '培训考试类别'
           }, 
           {
               field: 'examDegree',
               title: '培训考试等级'
           },
           {
               field: 'remarks',
               title: '备注'
           },{
               field: 'buttons',
               title: '操作',
               formatter:'buttoncellformat'
           }]
	});
	$('#confirmmodal').on('shown.bs.modal', function () {
		var count=$('#infotable').bootstrapTable('getSelections').length;
		  $('#modalcontent').html('确定删除选中的'+count+'位学生吗？');
		})
	$('#btn_add').click(function(){
		$('#addform').slideToggle();
	});
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
function deleteinfo(){
	$()
}
function initiframemodal(){$("#btnclick").click(function(){  
    var frameSrc = "${pageContext.request.contextPath}/studentedit";  
    $("#NoPermissioniframe").attr("src", frameSrc);  
    $('#NoPermissionModal').modal({ show: true, backdrop: 'static' });  
}); 
}
function buttoncellonclick(studentID){
	$(location).prop('href', "${pageContext.request.contextPath}/studentedit?studentID="+studentID);
}
function buttoncellformat(value,row,index){
	return '<button class="btn btn-default" onclick="buttoncellonclick('+row.studentID+')">修改</button>';
}
function modalconfirmed(){
	var selected=$('#infotable').bootstrapTable('getSelections');
	var params=[];
	$.each(selected, function(e, ele) {
		     params.push(ele.studentID)
		 })
	$.ajax({
		type : 'POST',
		url : "/Training/ajax/deletestudents",
		data : {
			"infolist":JSON.stringify(params),
			"${_csrf.parameterName}": "${_csrf.token}"
		},
		success:function(){
			$('#confirmmodal').modal('hide');
			$('#infotable').bootstrapTable('refresh');
		},
		error:function(errorxml){
			console.log(errorxml);
		},
		async : false
	});
}
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
			<li class="active">学生登记</li>
		</ol>

	</div>
	<div class="navbar-right ">
		<div class="navbar-text noselect" style="padding-right: 40px;"
			id="time"></div>
	</div>
	</nav>

	<div id="registerform" class="container">
		<div class="panel panel-default">

			<div id="toolbar" class="btn-group">
				<button id="btn_add" type="button" class="btn btn-default">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
				</button>
				<button id="btn_delete" type="button" class="btn btn-default"
					onclick="deleteinfo" data-toggle="modal"
					data-target="#confirmmodal">
					<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
				</button>
			</div>
			<table id="infotable" class="table table-hover table-bordered">
				<%--       <tr>
                <th>序号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>身份证号</th>
                <th>文化程度</th>
                <th>单位</th>
                <th>现有合格证书</th>
                <th>培训考试类别</th>
                <th>培训考试等级</th>
                <th>备注</th>
            </tr>
              <tbody>
                 <c:forEach var="info" items="${stuinfo}" varStatus="varStatus">
                <tr>
                    <td>${info.studentID}</td>
                    <td>${info.name}</td>
                    <td>${info.sex}</td>
                    <td>${info.identity}</td>
                    <td>${info.education}</td>
                    <td>${info.unit}</td>
                    <td>${info.certification}</td>
                    <td>${info.examType}</td>
                    <td>${info.examDegree}</td>
                    <td>${info.remarks}</td>
                </tr>
            </c:forEach>
            </tbody> --%>

			</table>

		</div>
		<form id="addform"
			action="${pageContext.request.contextPath}/studentregister"
			method="POST" style="display: none; margin-bottom: 100px;">
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
	<div class="modal fade" tabindex="-1" id="confirmmodal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">确定删除吗？</h4>
				</div>
				<div class="modal-body">
					<p id="modalcontent">确定删除选中的学生吗？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary"
						onclick="modalconfirmed()">确定</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<div class="modal fade" id="editmodal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<iframe id="editiframe" width="100%" height="50%" frameborder="0"></iframe>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" type="button"
						onclick="window.history.go(-1);">关 闭</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>