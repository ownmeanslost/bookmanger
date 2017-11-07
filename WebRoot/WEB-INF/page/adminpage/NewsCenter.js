(function($){
	events={};
	events.init=function(){
		events.initPage();
	};
	events.initPage=function(){
		$("#haveExpireList").bootstrapTable('destroy'); 
		$("#haveExpireList").bootstrapTable({
			url : contextPath + '/AdminController/GetAllExpireList',
			method : 'post', 
			pagination : true, 
			cache : false,
			sidePagination : "server", 
			queryParams : events.queryParams,
			pageNumber : 1, 
			pageSize : 5, 
			/* pageList : [ 5, 10, 15, 20 ], */
			/* strictSearch : true, */
		/*	 showColumns : true,*/
			 minimumCountColumns : 2,
			height : 300, 
			uniqueId : "ID", 

		columns : [ {
				field : 'user_id',
				title : '读者编号',
				align: 'center'
			}, {
				field : 'book_id',
				title : '图书编号',
				align: 'center',
			}]
		});
	};
	events.queryParams = function(params) {
		var temp = { 
			limit : params.limit, // 页面大小
			offset : params.offset, // 页码
		};
		return temp;
	};
	$(events.init);
})(jQuery);