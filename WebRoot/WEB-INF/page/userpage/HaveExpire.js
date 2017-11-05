(function($){
	events={};
	events.init=function(){
		events.initPage();
	};
	events.initPage=function(){
		/* $("#haveBorrowList").bootstrapTable('destroy'); */
		$("#haveExpireList").bootstrapTable({
			url : contextPath + '/UserController/GetHaveExpireList', 
			method : 'post', 
			pagination : false, 
			cache : false,
			sidePagination : "server", 
			queryParams : events.queryParams,
			pageNumber : 1, 
			pageSize : 5, 
			/* pageList : [ 5, 10, 15, 20 ], */
			/*
			 * strictSearch : true, showColumns : true, minimumCountColumns : 2,
			 */ 
			height : 300, 
			uniqueId : "ID", 

		columns : [ {
				field : 'isdn',
				title : 'ISDN',
				align: 'center'
			}, {
				field : 'bookName',
				title : '书名',
				align: 'center',
			} ,{
				field:'return_time',
				title:'归还时间',
				align: 'center',
				
			},{
				field:'remainingTime',
				title:'剩余时间(天)',
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