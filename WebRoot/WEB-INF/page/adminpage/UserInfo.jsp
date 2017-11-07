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

<title>读者管理</title>

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

	<!-- 其他 -->

	<ul class="nav nav-tabs">
		<li class="active"><a href="#advice" data-toggle="tab"
			id="adviceTab">查询读者</a></li>
		<li><a href="#news" data-toggle="tab" id="newsTab">删除读者</a></li>
		<li><a href="#newBooks" data-toggle="tab" id="newBooksTab">修改信息</a></li>
	</ul>
	<!--查询读者  -->
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="advice">
			<div class="panel panel-default">
				<div class="panel-body">
					<!--模糊查询  -->
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-xs-2 control-label">读者编号</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="user_id"
									placeholder="请输入读者编号">
							</div>
							<div class="col-xs-2">
								<input type="button" value="查找" id="checkById"
									class="btn btn-primary">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label">读者姓名</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="userName"
									placeholder="请输入读者姓名">
							</div>
							<div class="col-xs-2">
								<input type="button" value="查找" id="checkByName"
									class="btn btn-primary">
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-2 control-label">身份证</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="idNum"
									placeholder="请输入读者身份证号">
							</div>
							<div class="col-xs-2">
								<input type="button" value="查找" id="checkByIdNum"
									class="btn btn-primary">
							</div>
						</div>
					</form>
					<!--模糊查询  -->
					<!--模糊查找分页显示  -->
					<table class="table" id="tb_order" data-toggle="table" data-height="300">
						<thead>
						<tr>
							<th data-field="user_id" data-align="center">读者编号</th>
							<th data-field="name" data-align="center">姓名</th>
							<th data-field="password" data-align="center">密码</th>
							<th data-field="sex" data-align="center">性别</th>
							<th data-field="id_num" data-align="center">身份证</th>
							</tr>
						</thead>
					</table>
					
				</div>
			</div>

		</div>
		<!--查询读者  -->
		<!--删除读者  -->
		<div class="tab-pane fade" id="news">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-xs-2 control-label">读者编号</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="delUser_id"
									placeholder="请输入读者编号">
							</div>
							<div class="col-xs-2">
								<input type="button" value="删除" id="delUser"
									class="btn btn-primary">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--删除读者  -->
		<!--修改信息  -->
		<div class="tab-pane fade" id="newBooks">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-xs-2 control-label">读者编号</label>
							<div class="col-xs-3">
								<input type="text" class="form-control" id="resetUser_id"
									placeholder="请输入读者编号">
							</div>
							<div class="col-xs-2">
								<input type="button" value="密码重置" id="resetPassword"
									class="btn btn-primary">
							</div>
						</div>
					</form>
				</div>
			</div>
			<!--修改信息  -->
		</div>
	</div>
	<script type="text/javascript" src="page/adminpage/UserInfo.js"></script>
</body>
</html>
