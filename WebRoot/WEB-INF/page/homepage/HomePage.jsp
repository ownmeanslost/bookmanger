<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	HttpSession s = request.getSession();
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
<style type="text/css">
#yanZhengMa {
	border: 0;
	padding: 0;
}
</style>
<script type="text/javascript">
	var page={};
	(function(){
	page.num=1;
	})();
</script>
</head>

<body>

	<div class="container-fluid">
		<div class="col-xs-14" style="text-align:center;">图书管理</div>
		<div class="col-xs-3">
			<!--登录  -->
			<form class="form-horizontal" role="form" id="nima" method="post">
				<div class="form-group">
					<label class="col-xs-4 control-label">用户名：</label>
					<div class="col-xs-8">
						<input type="text" class="form-control" id="loginName"
							name="zhuceName" placeholder="请输入登录账号">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-4 control-label">密码：</label>
					<div class="col-xs-8">
						<input type="password" class="form-control" placeholder="请输入密码"
							id="loginPassword" name="loginPassword">
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-4 control-label">验证码：</label>
					<div class="col-xs-5">
						<input type="text" class="form-control" placeholder="输入验证码"
							id="loginYanZhengMa" name="loginYanZhengMa">
					</div>
					<div class="col-xs-3">
						<img class="form-control" id="yanZhengMa"> <input
							type="hidden" id="hiden_code" name="hiden_code">
					</div>

				</div>
				<div class="form-group">
					<a class="col-xs-4 control-label" id="forgetPassword">忘记密码？</a>
				</div>
				<div style="text-align:center;" class="form-group">
					<input type="submit" value="登录" class="btn btn-primary" id="login">
					<input type="button" value="注册" class="btn btn-primary"
						data-toggle="modal" data-target="#zhuCeModal" id="zhuCe">
				</div>
			</form>


			<div class="row" style="text-align:center;">
				<input id="checkBook" type="button" value="图书查询"
					class="btn btn-primary">
			</div>
			<div class="row" style="text-align:center;">
				<input type="button" value="读者须知" id="readerKnow"
					class="btn btn-primary">
			</div>
		</div>

		<!-- 注册框（Modal） -->
		<div class="modal fade" id="zhuCeModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true" data-easein="perspectiveLeftIn">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">注册</h4>
					</div>
					<div class="modal-body">

						<form class="form-horizontal" role="form" id="register-form"
							method="post">
							<div class="form-group">
								<label class="col-xs-2 control-label">姓名</label>
								<div class="col-xs-4">
									<input type="text" class="form-control" id="zhuceName"
										name="zhuceName" placeholder="请输入名字">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">性别</label>
								<div class="col-xs-4">
									<select class="form-control" id="sex">
										<option>男</option>
										<option>女</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">身份证号</label>
								<div class="col-xs-4">
									<input type="text" class="form-control" id="idNum" name="idNum"
										placeholder="请输入身份证号">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">手机号</label>
								<div class="col-xs-4">
									<input type="text" class="form-control" id="phone" name="phone"
										placeholder="请输入手机号">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">密码</label>
								<div class="col-xs-4">
									<input type="password" class="form-control" id="userPassword"
										name="userPassword">
								</div>
							</div>
							<div class="form-group">
								<label class="col-xs-2 control-label">确认密码</label>
								<div class="col-xs-4">
									<input type="password" class="form-control"
										id="userSecPassword" name="userSecPassword">
								</div>
							</div>
							<input type="submit" value="注册" id="ZhuCeFinish"> <input
								type="reset" value="重置" id="reset1">
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<!-- 	<input type="submit" value="注册" id="ZhuCeFinish"> -->

					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
		<!-- 注册框（Modal） -->
		<!-- 其他 ||图书查询-->
		<div class="col-xs-14">
			<iframe src="HomePageTiaoZhuan/Other" id="iframepage" frameborder="0"
				scrolling="auto" marginheight="0" marginwidth="0" class="col-xs-9"></iframe>
		</div>
		<!-- 其他 ||图书查询-->

		<!-- 读者须知框（Modal） -->
		<div class="modal fade" id="readerModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true" data-easein="tada">
			<div class="modal-dialog">
				<div class="modal-content"></div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		<!-- 读者须知框（Modal） -->
	</div>

	<script type="text/javascript">
		window.onload = function() {
			var iframe = document.getElementById("iframepage");
			iframe.style.height = window.innerHeight + 'px';
		};
	</script>
	<!--  	// add the animation to the modal-->
	<script type="text/javascript">

	$(".modal").each(function(index) {
	  $(this).on('show.bs.modal', function(e) {
	    var open = $(this).attr('data-easein');
	    if (open == 'shake') {
	      $('.modal-dialog').velocity('callout.' + open);
	    } else if (open == 'pulse') {
	      $('.modal-dialog').velocity('callout.' + open);
	    } else if (open == 'tada') {
	      $('.modal-dialog').velocity('callout.' + open);
	    } else if (open == 'flash') {
	      $('.modal-dialog').velocity('callout.' + open);
	    } else if (open == 'bounce') {
	      $('.modal-dialog').velocity('callout.' + open);
	    } else if (open == 'swing') {
	      $('.modal-dialog').velocity('callout.' + open);
	    } else {
	      $('.modal-dialog').velocity('transition.' + open);
	    }

	  });
	});
	</script>
	<script type="text/javascript" src="page/homepage/HomePage.js"></script>



</body>
</html>
