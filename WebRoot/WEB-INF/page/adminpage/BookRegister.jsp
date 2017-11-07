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
<link rel="stylesheet" type="text/css"
	href="scripts/bootstrap/css/fileinput.min.css"></link>
<link rel="stylesheet" type="text/css"
	href="scripts/bootstrap/css/summernote.css"></link>
<link rel="stylesheet" type="text/css"
	href="scripts/bootstrap/css/bootstrap-datetimepicker.min.css"></link>
<script type="text/javascript" src="scripts/bootstrap/js/fileinput.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap/js/fileinput_locale_zh.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap/js/summernote.min.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap/js/summernote-zh-CN.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"
	src="scripts/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
</head>

<body>
	<div class="container">
		<form class="form-horizontal" role="form" id="bookRegister-form">
			<div class="form-group">

				<label class="col-xs-2 control-label">ISDN</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="ISDN" name="ISDN">
				</div>
				<label class="col-xs-2 control-label">书名</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="bookName"
						name="bookName">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">作者</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="author" name="author">
				</div>
				<label class="col-xs-2 control-label">出版社</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="printer" name="printer">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">版次</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="order" name="order">
				</div>
				<label class="col-xs-2 control-label">库存</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="kucun" name="kucun">
				</div>


			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">分类</label>
				<div class="col-xs-4">
					<select class="form-control" id="minclude">
						<option>计算机类</option>
						<option>文学类</option>
						<option>艺术类</option>
						<option>历史类</option>
					</select>
				</div>
				<label for="printTime" class="control-label col-xs-2">出版时间</label>
				<div class="date form_date col-xs-4" data-date=""
					data-date-format="yyyy-mm-dd" data-link-field="dtp_input1"
					data-link-format="yyyy-mm-dd">
					<input size="16" type="text" value="" readonly id="printTime">
					<span class="add-on"><i class="icon-remove"></i></span> <span
						class="add-on"><i class="icon-th"></i></span> <input type="hidden"
						id="dtp_input1" /><br />
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">目录图片</label>
				<div class="col-xs-8">
					<input id="inputfile" name="inputfile" type="file"
						class="file-loading" data-show-upload="false"
						data-show-caption="true">
				</div>
			</div>
			<div class="form-group">
				<label class="col-xs-2 control-label">简介</label>
				<div class="col-xs-10">
					<div id="intruduce" class="summernote"></div>
				</div>

			</div>

			<div class="form-group" style="text-align: center;">

				<input type="submit" value="录入" class=" btn btn-primary" id="luRu">

				<input type="reset" value="重置" class="btn btn-primary" id="reset1">
				<input type="button" value="删除图书" class=" btn btn-primary"
					data-toggle="modal" data-target="#delteBookModal">

			</div>
		</form>
	</div>
	<!-- 图书删除（Modal） -->
	<div class="modal fade" id="delteBookModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">图书删除</h4>
				</div>
				<div class="modal-body">

					<form class="form-horizontal" role="form" id="delBook-form"
						method="post">
						<div class="form-group">
							<label class="col-xs-2 control-label">ISDN</label>
							<div class="col-xs-4">
								<input type="text" class="form-control" id="delISDN"
									name="delISDN" placeholder="请输入ISDN">
							</div>
							<div class="col-xs-2">
							<input type="submit" class="btn btn-primary" value="删除"
						id="delteBook">
						</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>



				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- 注图书删除（Modal） -->
	<script type="text/javascript" src="page/adminpage/BookRegister.js"></script>

</body>
</html>
