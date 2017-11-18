(function($) {
	var events = {};
	events.init = function() {
		// 加载
		events.adviceFenye();
	};
	
	//使用手册
	$("#moHuJieYue").click(function(){
		$("#readerKnow",parent.document).click();
		
	});
	$("#newsTab").click(function(){
		$("#demo2").text("");
		events.others('/HomePageTiaoZhuan/NewsFenYe', 1, '#demo2');
	});
	$("#adviceTab").click(function(){
		events.adviceFenye();
	});
	$("#newBooksTab").click(function(){
		events.newBookClick();
	});
	
	//加载新书推荐
	events.newBookClick=function(){
		$.ajax({
			url : contextPath + '/HomePageTiaoZhuan/NewBooksFenYe',
			datatype : 'json',
			type : "Post",
			data : "id=1" ,
		     async:false, 
			success : function(data) {
				if (data != null) {
					$("#demo3").text("");
					$.each(eval(data.rows), function(index, item) { // 遍历返回的json
					
						$("#demo3").append('<div class="col-xs-3"><div class="thumbnail">'
								+'<img src="'+item.list+'" alt="通用的占位符缩略图">'
								+'<div class="caption text-center"><h3><a href="'+contextPath
								+'/HomePageTiaoZhuan/GoToBookInfo?ISDN='
								+item.book_id+'"  target="_blank">'+item.book_name+'</a></h3></div></div></div>');
					});

					var pageCount = Math.ceil((data.total/12)); // 取到pageCount的值(把返回数据转成object类型)
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
										$("#demo3").text("");
										$.each(eval(data1.rows), function (index, item) { // 遍历返回的json
										
											$("#demo3").append('<div class="col-xs-3"><div class="thumbnail">'
													+'<img src="'+item.list+'" alt="通用的占位符缩略图">'
													+'<div class="caption text-center"><h3><a href="'+contextPath
													+'/HomePageTiaoZhuan/GoToBookInfo?ISDN='
													+item.book_id+'"  target="_blank">'+item.book_name+'</a></h3></div></div></div>');
											});
								}
							}
							});
						},
						
					};
					$('#example3').bootstrapPaginator(options);  	
				}
			
			}
		});
	};
	// 加载新闻
	events.others = function(path, carId, selName) {
		$.ajax({
			url : contextPath + '/HomePageTiaoZhuan/NewsFenYe',
			datatype : 'json',
			type : "Post",
		     async:false, 
			data : "id=" + carId,
			success : function(data) {
				if (data != null) {

					$.each(eval(data.rows), function(index, item) { // 遍历返回的json

						$(selName).append(
								'<li class="news-item">' + item.title
										+ '<a href='+contextPath+'/HomePageTiaoZhuan/GoToNewsContent?guid='+item.guid +' target="_blank">Read more...</a></li>');
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
										
										$(selName).append('<li class="news-item">'+item.title+'<a  href='+contextPath+'/HomePageTiaoZhuan/GoToNewsContent?guid='+item.guid +' target="_blank">Readmore...</a></li>'); });
									}
								}	 
							});
						},
						
					};
				 $('#example2').bootstrapPaginator(options);  	
				}
			}
		});
	};
	events.adviceFenye=function(){
		$("#advice_").bootstrapTable({
			url : contextPath + '/HomePageTiaoZhuan/BulletinFenYe',
			method : 'post', 
			pagination : true, 
			toolbar : '#toolbar', // 工具按钮用哪个容器
			cache : false,
			sidePagination : "server", 
			contentType : "application/x-www-form-urlencoded",
			pageNumber : 1, 
			pageSize : 5, 
			/* pageList : [ 5, 10, 15, 20 ], */
			/* strictSearch : true, */
		/*	 showColumns : true,*/
			 minimumCountColumns : 2,
			height : 400, 
			uniqueId : "ID", 

		columns : [ {
				field : 'user_id',
				title : '读者编号',
				align: 'center'
			}, {
				field : 'book_id',
				title : '图书编号',
				align: 'center',
			}, {
				field : 'bookName',
				title : '图书名',
				align: 'center',
			}]
		});
	};

	$(events.init);
})(jQuery);