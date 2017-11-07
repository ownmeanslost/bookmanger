(function($){
	events={};
	events.init=function(){
		events.findUser();
		events.delUser();
		events.resetUser();
	};
	var num='';
	events.initPage=function(){
		$("#tb_order").bootstrapTable('destroy'); 
		$("#tb_order").bootstrapTable({
			url : contextPath + '/AdminController/GetUserList', 
			method : 'post', 
			pagination : true, 
			cache : false,
			contentType : "application/x-www-form-urlencoded",
			sidePagination : "server", 
			queryParams : events.queryParams,
			pageNumber : 1, 
			pageSize : 5, 
			/* pageList : [ 5, 10, 15, 20 ], */
			/* strictSearch : true, */
		/*	 showColumns : true,*/
			 minimumCountColumns : 2,
		/*	height : 300, */
			uniqueId : "ID", 

		columns : [ {
				field : 'user_id',
				title : '读者编号',
				align: 'center'
			}, {
				field : 'name',
				title : '姓名',
				align: 'center',
			},
			{
				field : 'password',
				title : '密码',
				align: 'center',
			},
			{
				field : 'sex',
				title : '性别',
				align: 'center',
			},{
				field : 'id_num',
				title : '身份证',
				align: 'center',
			}]
		});
	};
	events.queryParams = function(params) {
		var temp = { 
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			number:num,//判断是哪个button传来的
			user_id:$("#user_id").val(),
			name:$("#userName").val(),
			id_num:$("#idNum").val()
		};
		return temp;
	};
	/**
	 * 点击事件
	 */
	events.findUser=function(){
		$("#checkById").click(function(){
			num="1";
			events.initPage();
		});
		$("#checkByName").click(function(){
			num="2";
			events.initPage();
		});
		$("#checkByIdNum").click(function(){
			num="3";
			events.initPage();
		});
	}
	events.delUser=function(){
		$("#delUser").click(function(){
			var result= confirm("确定要删除？");
			if(result){
				$.ajax({
					type:'post',
					url:contextPath+'/AdminController/DelUser',
					data:{
						user_id:$("#delUser_id").val(),
					},
					success:function(data){
						if(data=="1"){
							alert("删除成功！");
						}else{
							alert("改读者不存在");
						}
					}
					
				});
			}else{
				return false;
			}
			
		});
	};
	events.resetUser=function(){
		$("#resetPassword").click(function(){
			var result= confirm("确定要重置密码？");
			if(result){
				$.ajax({
					type:'post',
					url:contextPath+'/AdminController/ResetUserPassword',
					data:{
						user_id:$("#resetUser_id").val(),
					},
					success:function(data){
						if(data=="1"){
							alert("重置成功！");
						}else{
							alert("改读者不存在");
						}
					}
					
				});
			}else{
				return false;
			}
			
		});
	};
	$(events.init);
})(jQuery);