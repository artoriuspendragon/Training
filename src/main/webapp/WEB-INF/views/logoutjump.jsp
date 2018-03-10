<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/resource/loginpage.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var settime = 5;
		setInterval(function() {
			settime--;
			console.log(settime);
			if (settime < 0) {
				$(location).attr('href', '/Training/slogin');
			}
		}, 1000);
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>退出登录</title>
</head>

<body>
	<div class="centerform">
		<div class="centertitle" style="margin-top:auto; margin-bottom:auto;">退出登录成功！</div>
	</div>
</body>
</html>