(function($) {
	events = {};
	events.init = function() {
		events.initUserInfo();
		events.resetClick();
	};
	// 初始化表单
	events.initUserInfo = function() {
		$("#user_id").val(model.user_id);
		$("#oldPassword").val(model.password);
	};
	// 重置
	events.resetClick = function() {
		$("#reset1").click(function() {
			$("#newPassword").val("");
			$("#secPassword").val("");
			$("#upDatePassword-form").data('bootstrapValidator').resetForm(); 
		});

	};

	// 校验
	$("#upDatePassword-form").bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/* input状态样式图片 */
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			newPassword : {
				message : '密码无效',
				validators : {
					notEmpty : {
						message : '新密码不能为空'
					},
					StringLength : {
						min : 1,
						max : 8,
						message : '用户名长度大于6位并且小于30位'
					}
				}
			},
			secPassword : {
				validators : {
					notEmpty : {
						message : '第二次密码不能为空'
					},
					StringLength : {
						min : 1,
						max : 8,
						message : '用户名长度大于6位并且小于30位'
					},
					identical : {
						field : 'newPassword',
						message : '*两次输入密码不一致'
					}
				}
			},

		}

	}).on('success.form.bv', function(e) {
		e.preventDefault();
		// 提交
		$.ajax({
			type : 'post',
			url :contextPath+'/UserController/UpdateUserInfo',
			data : events.queryParams(),
			success : function(data) {
				if (data == "1") {
					$("#newPassword").val("");
					$("#secPassword").val("");
					$("#upDatePassword-form").data('bootstrapValidator').resetForm(); 
					alert("修改成功");
					
				} else {
					alert("修改失败");
				}
			}
		});

	});
	events.queryParams=function(params){
		var temp={
			user_id:model.user_id,
			password:$("#newPassword").val(),
		};
		return temp;
	};
	$(events.init);
})(jQuery);