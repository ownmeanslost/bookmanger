(function($) {

	events = {};
	events.init = function() {
		events.updatePasswordClick();
		events.initUserInfo();
		events.changeIfram(0);
	};
	// liclick事件
	events.updatePasswordClick = function() {
		$(".list-group li").click(function() {
			$('.active').removeClass('active');
			// 当前点击的li加上class
			$(this).addClass("active");
			var index = $(".list-group li").index(this);
			events.changeIfram(index);
		});
	};
	// 改变ifram的src
	events.changeIfram = function(param) {
		var myfaram = $("#iframepage");
		switch (param) {
		case 0:
			myfaram.attr("src", contextPath + "/UserController/GoToUserInfo");
			break;
		case 1:
			myfaram.attr("src", contextPath + "/UserController/UpdatePassword");
			break;
		case 2:
			myfaram.attr("src", contextPath + "/UserController/HaveBorrow");
			break;
		case 3:
			myfaram.attr("src", contextPath + "/UserController/NewsCenter");
			break;
		case 4:
			myfaram.attr("src", contextPath + "/UserController/BorrowCenter");
			break;
		default:
			break;
		}
	};
	events.initUserInfo = function() {
		$.ajax({
			type : 'post',
			url : contextPath + "/UserController/GetUserInfo",
			success : function(data) {
				if (data != null) {
					$("#userName").val(data.name);
				}

			}

		});
	};
	$(events.init);
})(jQuery);