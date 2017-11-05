(function($){
	var events={};
	events.init=function(){
		events.readerKnowContent();
	};
	events.readerKnowContent=function(){
	
		$.ajax({
			type : 'post',
			url : contextPath + '/HomePageTiaoZhuan/GetReaderKnow',
			success:function(data){
				if(data!=null){
					$("#modal-body").text(data.content);
				}
				
			}
		});
	};
	$(events.init);
})(jQuery);