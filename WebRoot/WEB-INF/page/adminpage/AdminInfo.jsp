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
	model.name="<c:out default='' value='${administer.name}'/>";
	model.adm_id="<c:out default='' value='${administer.adm_id}'/>";
	})();
</script>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form" id="upDatePassword-form">
			<div class="form-group">
				<label class="col-xs-2 control-label">姓名：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="userName"
						name="userName" disabled="disabled">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">密码：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="adminPassword"
						name="adminPassword">
				</div>
			</div>
				<div class="form-group">
				<label class="col-xs-2 control-label">确认密码：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="secPassword"
						name="secPassword">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">账号：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="phoneNum"
						name="phoneNum" disabled="disabled">
				</div>
			</div>
			<div class="form-group" style="text-align:center;">
				<input type="submit" value="确定" class="btn btn-primary" id="queDing">
				<input type="button" value="重置" class="btn btn-primary" id="reset1">
			</div>
		</form>
	</div>
	<script type="text/javascript" src="page/adminpage/AdminInfo.js"></script>



</body>
</html>
