(function($){
	events={};
	events.init=function(){
		events.initUserInfo();
	};
	events.initUserInfo=function(){
		$("#userName").val(model.user_id);
		$("#userSex").text(model.sex);
		$("#user_idNum").val(model.id_num);
	};
	$(events.init);
})(jQuery);