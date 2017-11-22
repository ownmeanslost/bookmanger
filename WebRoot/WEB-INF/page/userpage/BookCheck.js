(function($) {
	var events = {};
	events.init = function() {
		events.moHuJieYueClick();
	};
	$("#jingQueCheck").click(function() {
		// 精确查询
		var ISDN1 = $("#ISDN1").val();
		$("#jingQueModal").modal({
			remote : contextPath + "/UserController/JingQueCheck?ISDN=" + ISDN1
		});
	});
	// 弹出框关闭后清除弹出框，否则会有缓存
	$("#jingQueModal").on("hidden.bs.modal", function() {
		$(this).removeData("bs.modal");

	});

	$("#moHuCheck").click(function() {
		$("#tb_order").bootstrapTable('destroy');
		$('#tb_order').bootstrapTable({
			url : contextPath + '/HomePageTiaoZhuan/BookList',
			method : 'post',
			toolbar : '#toolbar', // 工具按钮用哪个容器
			contentType : "application/x-www-form-urlencoded",
			pagination : true,
			cache : false,
			queryParams : events.queryParams,
			sidePagination : "server",
			pageNumber : 1,
			pageSize : 5,
			pageList : [ 5, 10, 15, 20 ], 
			strictSearch : true,
			showColumns : true,
			showRefresh : true,
			minimumCountColumns : 2,
			clickToSelect : true,
			height : 400,
			uniqueId : "ID",
			singleSelect : true, // 单选checkbox
			columns : [ {
				checkbox : true
			}, {
				field : 'book_id',
				title : 'ISDN'
			}, {
				field : 'book_name',
				title : '书名'
			}, {
				field : 'author',
				title : '作者',

			}, {
				field : 'printer',
				title : '出版社',

			}, {
				field : 'order',
				title : '版次',
			}, {
				field : 'kucun',
				title : '库存',
			} ]
		});
		$("#moHuJieYue").attr("type", "button");
	});
	/**
	 * 模糊借阅点击事件
	 */
	events.moHuJieYueClick = function() {
		$("#moHuJieYue").click(
				function() {

					var a = $("#tb_order").bootstrapTable('getSelections');

					if (a.length == 1) {
						var moHuISDN = a[0].book_id;
						$.ajax({
							type : 'post',
							url : contextPath
									+ '/UserController/BorrowBook?ISDN='
									+ moHuISDN,
							success : function(data) {
								if (data.result == "1") {
									var result = confirm('借阅成功，归还时间为：'
											+ data.returnTime);
								} else if (data.result == "2") {
									alert("同一本书不能借两本");
								} else if (data.result == "3") {
									alert("该书无库存");
								} else if (data.result == "4") {
									alert("最多借5本");
								}
								$("#tb_order").bootstrapTable('refresh');
							}

						});
					} else {
						alert("请选中一行")
					}

				});
	}
	events.queryParams = function(params) {
		var temp = {
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			book_name : $("#mbook_name").val(),
			author : $("#mauthor").val(),
			printer : $("#mprinter").val(),
			include : $("#minclude option:selected").text(),
		};
		return temp;
	};
	$(events.init);
})(jQuery);