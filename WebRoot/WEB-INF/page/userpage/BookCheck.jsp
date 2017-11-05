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

<title>图书查找</title>

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
	<!-- 精确查询 -->
	<form class="form-horizontal" role="form"
		style="background-color: gray;">
		<div class="form-group">
			<label class="col-xs-2 control-label">ISDN</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="ISDN1"
					placeholder="请输入isdn">
			</div>
			<input type="button" value="精确查找" id="jingQueCheck">
		</div>
	</form>
	<!-- 精确查询 -->
	<!-- 精确查询框（Modal） -->
	<div class="modal fade" id="jingQueModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content"></div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 精确查找框（Modal） -->

	<!--模糊查询  -->
	<form class="form-horizontal" role="form"
		style="background-color: gray;">
		<div class="form-group">
			<label class="col-xs-2 control-label">图书名</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="mbook_name"
					placeholder="请输入图书名">
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-2 control-label">作者</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="mauthor"
					placeholder="请输入作者">
			</div>
		</div>
		<div class="form-group">
			<label class="col-xs-2 control-label">出版社</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" id="mprinter"
					placeholder="请输入出版社">
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

			<input type="button" value="模糊查找" id="moHuCheck">
		</div>
	</form>
	<!--模糊查询  -->
	<!--模糊查找分页显示  -->
	<table class="table" id="tb_order">
	
	</table>
	<div id="toolbar">
		<input type="hidden" class="btn btn-primary jieYue" value="借阅"
			id="moHuJieYue">
	</div>
	<script type="text/javascript" src="page/userpage/BookCheck.js"></script>
</body>
</html>
