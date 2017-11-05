(function($){
	var events={};
	events.init=function(){
		events.tijiao();
		events.resetForm();
	};
	// 提交
	events.tijiao=function(){
		$("#forgetPassword").bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/* input状态样式图片 */
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				user_id : {
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
				newPassword : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						StringLength : {
							min : 1,
							max : 8,
							message : '用户名长度大于6位并且小于8位'
						}
					}
				},
				secPassword : {
					validators : {
						notEmpty : {
							message : '密码不能为空'
						},
						identical : {
							field : 'newPassword',
							message : '*两次输入密码不一致'
						}
					}
				}
			}
			}).on('success.form.bv', function(e) {
				e.preventDefault();
				$.ajax({
					url:contextPath+'/HomePageTiaoZhuan/FindPassword',
					type:'post',
					data:events.queryparames(),
					success:function(data){
						if(data=="1"){
							alert("密码修改成功");
							$(location).attr('href', contextPath+'/Login');
						}
						if(data=="2"){
							alert("用户名与身份证号不匹配");
						}
					}
					
				});
			});		
	};
	//重置表单
	events.resetForm=function(){
		$("#reset1").click(function() {
				$("#forgetPassword").data('bootstrapValidator').resetForm();  
			});
	}
	events.queryparames=function(parames){
		var temp={
			user_id:$("#user_id").val(),	
			id_num:$("#idNum").val(),
			password:$("#newPassword").val(),
			
		};
		return temp;
	}
	$(events.init);
	
})(jQuery);