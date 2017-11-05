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

<title>精确查找</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<jsp:include page="/WEB-INF/scripts/common/common.jsp"></jsp:include>
<script type="text/javascript"
	src="scripts/bootstrap/js/fileinput.min.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap/js/fileinput_locale_zh.js"></script>
<link rel="stylesheet" type="text/css"
	href="scripts/bootstrap/css/fileinput.min.css"></link>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group">

				<label class="col-xs-2 control-label">ISDN</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="ISDN">
				</div>
				<label class="col-xs-2 control-label">书名</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="bookName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">作者</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="author">
				</div>
				<label class="col-xs-2 control-label">出版社</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="printer">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">版次</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="order">
				</div>
				<label class="col-xs-2 control-label">库存</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="kucun">
				</div>


			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">分类</label>
				<div class="col-xs-4">
					<select class="form-control" id="minclude">
						<option>--请选择--</option>
						<option>计算机</option>
						<option>文学</option>
						<option>艺术</option>
						<option>历史</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">目录</label> <img alt="" src=""
					class="col-xs-4 img-thumbnail" id="list">
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">简介</label>
				<div class="col-xs-8">
					<textarea class="form-control" rows="3" id="intruduce"></textarea>
				</div>

			</div>

			<div class="form-group" style="text-align: center;">

				<input type="submit" value="录入" class=" btn btn-primary" id="luRu">
				<input type="reset" value="重置" class="btn btn-primary">

			</div>
		</form>
	</div>

	<script type="text/javascript" src="page/adminpage/BookRegister.js"></script>
</body>
</html>
