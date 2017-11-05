<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>忘记密码</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="/WEB-INF/scripts/common/common.jsp"></jsp:include>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form" id="forgetPassword">
			<div class="form-group">
				<label class="col-xs-2 control-label">用户名</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="user_id"
						name="user_id" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">身份证号</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="idNum" name="idNum"
						placeholder="请输入身份证号">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">新密码</label>
				<div class="col-xs-4">
					<input type="password" class="form-control" id="newPassword"
						name="newPassword">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">再次输入密码</label>
				<div class="col-xs-4">
					<input type="password" class="form-control" id="secPassword"
						name="secPassword">
				</div>
			</div>
			<div  class="form-group" style="text-align:center;">
				<input type="submit" value="确定" class="btn btn-primary" id="queDing">
				<input type="reset" value="重置" class="btn btn-primary" id="reset1">
			</div>
		</form>
	</div>
	<script type="text/javascript" src="page/homepage/ForgetPassword.js"></script>
</body>
</html>
