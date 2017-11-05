(function($) {
	var event = {};
	event.init = function() {
		event.initModel();
		event.BorrowClick();
	};
	// 查询结果
	event.initModel = function() {
		$.ajax({
			async : false,
			type : 'post',
			url : contextPath + '/HomePageTiaoZhuan/FindOneBook?ISDN='
					+ model.ISDN,
			success : function(data) {
				if (data == "") {

					$("#modal_body").html('该书不存在');

					/* alert("该书不存在"); */
				} else {
					$("#ISDN").attr("value", data.book_id);
					$("#bookName").attr("value", data.book_name);
					$("#author").attr("value", data.author);
					$("#printer").attr("value", data.printer);
					$("#order").attr("value", data.order);
					$("#intruduce").val(data.intruduce);
					$("#kucun").text(data.kucun);
				}
			}
		});

	};
	event.BorrowClick=function(){
		$("#jieYue").click(function(){
			$.ajax({
				type:'post',
				url:contextPath+'/UserController/BorrowBook?ISDN='+model.ISDN,
				success:function(data){
					if(data.result=="1"){
						var result = confirm('借阅成功，归还时间为：'+data.returnTime);  
						if(result){  
							$("#jingQueModal").modal('hide');
					    }else{  
					    	$("#jingQueModal").modal('hide');
					    }  
						
					
						//删除弹出框
						
					}else if(data.result=="2"){
						alert("同一本书不能借两本");
					}else if(data.result=="3"){
						alert("该书无库存");
					}else if(data.result=="4"){
						alert("最多借5本");
					}
				}
				
			});
		});
	};
	$(event.init);
})(jQuery);