(function($) {

	events = {};
	events.init = function() {
		events.updatePasswordClick();
		events.initUserInfo();
		events.changeIfram(0);
		events.QuitAndCancleClick();
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
			myfaram.attr("src", contextPath + "/AdminController/GoToAdminInfo");
			break;
		case 1:
			myfaram.attr("src", contextPath
					+ "/AdminController/GoToBookRegister");
			break;
		case 2:
			myfaram.attr("src", contextPath + "/AdminController/GoToUserInfo");
			break;
		case 3:
			myfaram
					.attr("src", contextPath
							+ "/AdminController/GoToNewsCenter");
			break;
		default:
			break;
		}
	};
	events.initUserInfo = function() {
		$.ajax({
			type : 'post',
			url : contextPath + "/AdminController/GetAdminInfo",
			success : function(data) {
				if (data != null) {
					$("#userName").val(data.name);
				}

			}

		});
	};

	events.QuitAndCancleClick = function() {
		$("#quit").click(function() {
			$(location).attr('href', contextPath + '/Login');
		});
		$("#cancle").click(
				function() {
					$.get(contextPath + "/AdminController/DelUserSeeion",
							function(result) {
								if (result == "1") {
									$(location).attr('href',
											contextPath + '/Login');
								}
							});
				})
	};
	$(events.init);
})(jQuery);