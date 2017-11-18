(function($) {
	var events = {};
	events.init = function() {
		events.initImg();
		events.login();
		events.yanZhengMaClick();
	};
	// 读者须知
	$("#readerKnow").click(function() {
		$("#readerModal").modal({
			remote : contextPath + "/HomePageTiaoZhuan/GoToReaderKnow"
		});
		$("#readerModal").modal('show');
	});

	$("#checkBook").click(
			function() {
				var ifram1 = $("#iframepage").attr("src",
						"HomePageTiaoZhuan/CheckBook");
			});
	// 重置
	$("#reset1").click(function() {
		$("#register-form").data('bootstrapValidator').resetForm();

	});

	$("#register-form").bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {/* input状态样式图片 */
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			zhuceName : {
				message : '用户名无效',
				validators : {
					notEmpty : {
						message : '用户名不能为空'
					},
				}
			},
			idNum : {
				validators : {
					notEmpty : {
						message : '身份证不能为空'
					},
					regexp : {
						regexp : /^(\d{18}|\d{17}X)$/,
						message : '请输入正确身份证'
					}
				}
			},
			phone : {
				validators : {
					notEmpty : {
						message : '手机号不能为空'
					},
					regexp : {
						regexp : /^[1][3-8]+\d{9}$/,
						message : '请输入正确手机号'
					}
				}
			},
			userPassword : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					StringLength : {
						min : 1,
						max : 8,
						message : '用户名长度大于6位并且小于30位'
					}
				}
			},
			userSecPassword : {
				validators : {
					notEmpty : {
						message : '密码不能为空'
					},
					identical : {
						field : 'userPassword',
						message : '*两次输入密码不一致'
					}
				}
			}
		}

	}).on('success.form.bv', function(e) {
		e.preventDefault();
		/* $("#ZhuCeFinish").attr("disabled",false); */

		// 提交
		$.ajax({
			type : 'post',
			url : contextPath + '/HomePageTiaoZhuan/zhuCe',
			data : events.queryParams(),
			success : function(data) {
				if (data == "1") {
					alert("注册成功");
					$("#zhuCeModal").on("hidden.bs.modal", function() {
						$(this).removeData("bs.modal");

					});

				} else {
					alert("注册失败");
				}
			}
		});

	});

	events.queryParams = function(params) {
		var temp = {
			user_id : $("#phone").val(),
			name : $("#zhuceName").val(),
			password : $("#userPassword").val(),
			sex : $("#sex option:selected").text(),
			id_num : $("#idNum").val(),

		};
		return temp;
	};
	$("#forgetPassword").attr("href",
			contextPath + "/HomePageTiaoZhuan/GotoForgetPassword");

	events.yanZhengMaClick = function() {
		$("#yanZhengMa").click(function() {
			events.initImg();
			
		});
		
	};

	// 初始化验证码的img
	events.initImg = function() {
		$("#yanZhengMa").attr(
				"src",
				contextPath + "/HomePageTiaoZhuan/GetYanZhengMa?it="
						+ Math.random());
		
		$("#yanZhengMa").load(function(){
			events.getYZSession();
		});
	};
	// 获得session
	events.getYZSession = function() {
		$.ajax({
			type : 'post',
			url : contextPath + "/HomePageTiaoZhuan/GetSession",
			/*async : false,*/
			success : function(data) {
				$("#hiden_code").attr("value", data);
			}
		});

	};
	/**
	 * 登录框初始化
	 */
	events.login = function() {
		$("#nima").bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/* input状态样式图片 */
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				hiden_code : {

				},
				loginYanZhengMa : {
					validators : {
						notEmpty : {
							message : '验证码不能为空'
						},
						identical : {
							field : 'hiden_code',
							message : '验证码错误'
						}
					}
				}
			}
		}).on('success.form.bv', function(e) {
			$.ajax({
				type : 'post',
				url : contextPath + '/HomePageTiaoZhuan/LoginYanZheng',
				data : {
					user_id : $("#loginName").val(),
					loginPassword : $("#loginPassword").val().toLowerCase()
				},
				success : function(data) {
						if (data == "1"|| data=="2") {
							$(location).attr('href', contextPath + '/HomePageTiaoZhuan/GoToUserPage');
							
						} else {
							var result=confirm("账号或者密码错误！");
							$("#loginYanZhengMa").val('');
							$("#nima").data('bootstrapValidator').resetForm();
							events.initImg();
						}
				}
			});
				return false;
				//这个return很重要，ajax+submit+同步时，如果ajax里面有跳转会先执行ajax跳转，在执行submit,这是页面会调回来
		});
	};
	// 登录点击事件
	
	$(events.init);
})(jQuery);