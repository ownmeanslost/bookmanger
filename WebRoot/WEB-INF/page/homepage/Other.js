(function($) {
	var events = {};
	events.init = function() {
		// 加载
		events.others('/HomePageTiaoZhuan/BulletinFenYe', 1, '#demo1');
	};
	$("#newsTab").click(function(){
		$("#demo2").text("");
		events.others('/HomePageTiaoZhuan/NewsFenYe', 1, '#demo2');
	});
	$("#adviceTab").click(function(){
		$("#demo1").text("");
		events.others('/HomePageTiaoZhuan/BulletinFenYe', 1, '#demo1');
	});
	$("#newBooksTab").click(function(){
		$("#demo3").text("");
		events.others('/HomePageTiaoZhuan/NewBooksFenYe', 1, '#demo3');
	});
	// 加载others
	events.others = function(path, carId, selName) {
		$.ajax({
			url : contextPath + path,
			datatype : 'json',
			type : "Post",
			data : "id=" + carId,
			success : function(data) {
				if (data != null) {

					$.each(eval(data.rows), function(index, item) { // 遍历返回的json

						$(selName).append(
								'<li class="news-item">' + item.content
										+ '<a href="#">Read more...</a></li>');
					});

					var pageCount = Math.ceil((data.total/5)); // 取到pageCount的值(把返回数据转成object类型)
					var options = {
						bootstrapMajorVersion : 1, // 版本
						totalPages: pageCount,
						itemTexts : function(type, page, current) {
							switch (type) {
							case "first":
								return "首页";
							case "prev":
								return "上一页";
							case "next":
								return "下一页";
							case "last":
								return "末页";
							case "page":
								return page;
							}
						},// 点击事件，用于通过Ajax来刷新整个list列表
						onPageClicked: function (event, originalEvent, type, page) { 
							$.ajax({ 
								url: contextPath + path, 
								type: "Post",
								data: "id=" + page,
								success: function (data1) { 
									if(data1 != null) { 
										$(selName).text("");
										$.each(eval(data1.rows), function (index, item) { // 遍历返回的json
										
										$(selName).append('<li class="news-item">'+item.content+'<a href="#">Readmore...</a></li>'); });
									}
								}	 
							});
						},
						
					};
					 if(selName=="#demo1"){
						 $('#example1').bootstrapPaginator(options); 
					 }
					 if(selName=="#demo2"){
						 $('#example2').bootstrapPaginator(options); 
					 }
					 if(selName=="#demo3"){
						 $('#example3').bootstrapPaginator(options); 
					 }
					
				}
			}
		});
	};
	/*
	 * $(".demo1").bootstrapNews({ newsPerPage: 10, autoplay: true,
	 * pauseOnHover:true, direction: 'up', newsTickerInterval: 4000, onToDo:
	 * function () { //console.log(this); } });
	 */
	$(events.init);
})(jQuery);