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

<title>图书信息</title>

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
	model.ISDN="<c:out default='' value='${ISDN}'/>";
	})();
	
</script>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group">

				<label class="col-xs-2 control-label">ISDN</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="ISDN"
						readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">书名</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="bookName"
						readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">作者</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="author"
						readonly="readonly">
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-2 control-label">出版社</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="printer"
						readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">库存</label> <label
					class="control-label" id="kucun"></label>


			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">版次</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="order"
						readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">图片目录</label> <img alt=""
					src="" class="col-xs-2 img-thumbnail" id="list">
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">简介</label>
				<div class="col-xs-8">
					<div id="intruduce"></div>
					<!-- <textarea class="form-control" rows="3" id="intruduce" readonly="readonly"></textarea> -->
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="page/homepage/JingQueCheck.js"></script>
</body>
</html>
