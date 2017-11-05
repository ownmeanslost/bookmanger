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

<title>图书管理</title>

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
			id="adviceTab">通知公告</a></li>
		<li><a href="#news" data-toggle="tab" id="newsTab">新闻中心</a></li>
		<li><a href="#newBooks" data-toggle="tab" id="newBooksTab">新书推荐</a></li>
	</ul>
	<!--通知公告  -->
	<div id="myTabContent" class="tab-content">
		<div class="tab-pane fade in active" id="advice">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12">
							<ul class="demo1 list-unstyled" id="demo1">

							</ul>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div id="example1"></div>
				</div>
			</div>

		</div>
		<!--通知公告  -->
		<!--新闻中心  -->
		<div class="tab-pane fade" id="news">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12">
							<ul class="demo2 list-unstyled" id="demo2">
							
							</ul>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					 <div id="example2"></div> 
				</div>
			</div>
		</div>
		<!--新闻中心  -->
		<!--新书推荐  -->
		<div class="tab-pane fade" id="newBooks">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="row">
						<div class="col-xs-12">
							<ul class="demo3 list-unstyled" id="demo3">

							</ul>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div id="example3"></div>
				</div>
			</div>
			<!--新书推荐  -->
		</div>
	</div>
	<script type="text/javascript" src="page/homepage/Other.js"></script>
</body>
</html>
