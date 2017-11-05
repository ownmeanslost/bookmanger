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

<title>读者</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="/WEB-INF/scripts/common/common.jsp"></jsp:include>
<script type="text/javascript">
	var model={};
	(function(){
	model.user_id=" <c:out default='' value='${user.user_id}'/>";
	model.sex=" <c:out default='' value='${user.sex}'/>";
	model.id_num=" <c:out default='' value='${user.id_num}'/>";
	})();
</script>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label class="col-xs-2 control-label">用户名：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="userName"
						name="userName" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">性别：</label> <label
					class="control-label" id="userSex">1</label>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">身份证号：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="user_idNum"
						name="user_idNum" disabled="disabled">
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="page/userpage/UserInfo.js"></script>



</body>
</html>
