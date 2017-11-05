(function($){
	var event={};
	// 注册
	$("#zhuCe").click(function(){
		$("#zhuCe" , parent.document).click(); 
		
	});
	event.init=function(){
		$.ajax({
			async: false,
			type : 'post',
			url : contextPath + '/HomePageTiaoZhuan/FindOneBook?ISDN='+model.ISDN,
			success : function(data) {
				if(data==""){
					
				   
					$("#modal_body").html('该书不存在');
			      
					/*alert("该书不存在");*/
				}else{
					$("#ISDN").attr("value",data.book_id);
					$("#bookName").attr("value",data.book_name);
					$("#author").attr("value",data.author);
					$("#printer").attr("value",data.printer);
					$("#order").attr("value",data.order);
					$("#intruduce").val(data.intruduce);
					$("#kucun").text(data.kucun);
					
					/*$("#list").attr("value",data.list);*/
					
					
					
				}
			}
		});

	};
	/*
	 * event.QueryForBook=function(){ $.ajax({ url:contextPath+'', type:'post',
	 * data:event.QueryParams(), success:function(data){ if(data==1){
	 * 
	 * }else{ alert("该书不存在"); } } }); };
	 */
/*
 * event.QueryParams=function(){ var temp={ book_id:$("#ISDN").val() }; };
 */
	$(event.init);
})(jQuery);