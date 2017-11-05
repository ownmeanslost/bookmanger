(function($){
	var events={};
	
	
	
	$("#jingQueCheck").click(function(){
		//精确查询
		var ISDN1=$("#ISDN1").val();
		$("#jingQueModal").modal({  
		    remote: contextPath+"/HomePageTiaoZhuan/JingQueCheck?ISDN="+ISDN1
		});
	});
	//弹出框关闭后清除弹出框，否则会有缓存
	$("#jingQueModal").on("hidden.bs.modal", function() {
		$(this).removeData("bs.modal");

	});
	
	$("#moHuCheck").click(function() {
		$("#tb_order").bootstrapTable('destroy'); 
		$('#tb_order').bootstrapTable({
			url : contextPath + '/HomePageTiaoZhuan/BookList', 
			method : 'post', 
			contentType : "application/x-www-form-urlencoded",
			pagination : true, 
			cache : false,
			queryParams : events.queryParams,
			sidePagination : "server", 
			pageNumber : 1, 
			pageSize : 5, 
			/*pageList : [ 5, 10, 15, 20 ],*/
			pagination: true,
			strictSearch : true,
			showColumns : true, 
			showRefresh : true, 
			minimumCountColumns : 2, 
			clickToSelect : true, 
			height : 400, 
			uniqueId : "ID", 

		columns : [ {
				checkbox : true
			}, {
				field : 'book_id',
				title : 'ISDN'
			}, {
				field : 'book_name',
				title : '书名'
			} ,{
				field:'author',
				title:'作者',
				
			},{
				field:'printer',
				title:'出版社',
				
			},{
				field:'order',
				title:'版次',
			},{
				field:'kucun',
				title:'库存',
			}]
		});

	});
	
	events.queryParams = function(params) {
		var temp = { 
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
			book_name: $("#mbook_name").val(), 
			author : $("#mauthor").val(), 
			printer:$("#mprinter").val(),
			include:$("#minclude option:selected").text(),
		};
		return temp;
	};
})(jQuery);