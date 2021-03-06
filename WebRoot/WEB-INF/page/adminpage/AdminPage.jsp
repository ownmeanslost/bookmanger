<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<title>管理员</title>

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

	<div class="container-fluid">
		<div class="col-xs-14" style="text-align:center;">管理员主界面</div>
		<form class="form-horizontal" role="form" >
		<div class="form-group">
			<label class="col-xs-1 control-label" >用户名：</label>
			<div class="col-xs-1">
				<input type="text" id="userName" class="form-control"
					name="userName" disabled="disabled">
			</div>
			<div class="col-xs-4">
				<input type="button" value="退出" class="btn btn-primary" id="quit"> <input
					type="button" value="注销" class="btn btn-primary" id="cancle">
			</div>
		</div>
		</form>
		<div class="col-xs-3">
			<ul class="list-group">
				<li class="active list-group-item" id="userInfo">个人信息修改</li>
				<li class="list-group-item" id="updatePassword">图书录入</li>
				<li class="list-group-item" id="haveBorrow">读者信息</li>
				<li class="list-group-item" id="newsCenter">消息中心</li>
			</ul>
		</div>

		<div class="col-xs-14">
			<iframe src="AdminController/GoToAdminInfo" id="iframepage"
				frameborder="0"  marginheight="0" marginwidth="0"
				class="col-xs-9"></iframe>
		</div>
	</div>

	<script type="text/javascript">
		window.onload = function() {
			var iframe = document.getElementById("iframepage");
			iframe.style.height = window.innerHeight + 'px';
		};
	</script>
	<script type="text/javascript" src="page/adminpage/AdminPage.js"></script>



</body>
</html>
