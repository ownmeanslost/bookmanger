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

<title>新闻页面</title>

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
	var model = {};
	(function() {
		model.title = "<c:out default='' value='${news.title}' />";
		model.content = "<c:out default='' value='${news.content}' />";
	})
</script>
</head>

<body>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h1 class="panel-title text-center"><c:out default=" " value="${news.title}"> </c:out></h1>
		</div>
		<div class="panel-body"><c:out default=" " value="${news.content}"> </c:out></div>
	</div>
	</div>
	<script type="text/javascript" src="page/homepage/NewsContent.js"></script>
</body>
</html>
