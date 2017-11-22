(function($) {
	var events = {};
	events.init = function() {
		//全局变量
		var fishId='';
		// 初始化编辑插件
		events.initSummer();
		// 初始化校验插件
		events.initLuRuJiaoYan();
		// 重置
		events.resetClick();
		// 初始化日历
		events.initCanlader();
		// 初始化图片上传插件
		events.fishFileInput();
		//初始化删除校验
		events.delJiaoYan();
	};
	events.initSummer = function() {
		$('.summernote')
				.summernote(
						{
							lang : 'zh-CN',
							height : 200, // set editor
							// height
							minHeight : null, // set minimum height of editor
							maxHeight : null, // set maximum height of editor
							focus : true,
							toolbar : [
									[
											'style',
											[ 'bold', 'italic', 'underline',
													'clear' ] ],
									[ 'fontsize', [ 'fontsize' ] ],
									[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
									[ 'color', [ 'color' ] ] ]
						});
	};
	events.fishFileInput = function() {
		$("#inputfile").fileinput({
			language : 'zh', // 设置语言
			autoReplace : true,
			uploadUrl : contextPath + '/AdminController/LoadPicture', // 上传的
			allowedFileExtensions : [ 'jpg', 'gif', 'png' ],// 接收的文件后缀
			uploadExtraData:{"id": 1, "fileName":'123.mp3'},
			uploadAsync : false, // 默认异步上传
			showUpload : false, // 是否显示上传按钮
			showRemove : true, // 显示移除按钮
			showPreview : true, // 是否显示预览
			showCaption : false,// 是否显示标题
			browseClass : "btn btn-primary", // 按钮样式
			dropZoneEnabled : false,// 是否显示拖拽区域
			maxFileSize : 0,// 单位为kb，如果为0表示不限制文件大小
			// minFileCount: 0,
			maxFileCount : 1, // 表示允许同时上传的最大文件个数
			enctype : 'multipart/form-data',
			validateInitialCount : true,
			previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
			msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			layoutTemplates : {
				actionDelete : '',
				actionUpload : '',
				actionZoom : ''
			},
			uploadExtraData : function(previewId, index) {
				// 向后台传递id作为额外参数，是后台可以根据id修改对应的图片地址。
				var obj = {};
				obj.id = fishId;
				return obj;
			}
		}).on("filebatchuploadsuccess", function(event, data) {

			var res = data.response;
			if (res) {
				var result=confirm("成功录入");
				
				
				
			} else {
				alert('上传失败');
			}
			$("#bookRegister-form").reset();	
		});
		
	};

	// 重置
	events.resetClick = function() {
		$("#reset1").click(function() {
			$("#bookRegister-form").data('bootstrapValidator').resetForm();
		});

	};
	events.queryParams = function(params) {
		var temp = {
			book_id : $("#ISDN").val(),
			book_name : $("#bookName").val(),
			author : $("#author").val(),
			printer : $("#printer").val(),
			order : $("#order").val(),
			print_time : $("#printTime").val(),
			intruduce : $('#intruduce').summernote('code'),
			include : $("#minclude option:selected").text(),
			kucun : $("#kucun").val(),
		};
		return temp;
	};
	/**
	 * 图书录入表单校验
	 */
	events.initLuRuJiaoYan = function() {
		// 校验
		$("#bookRegister-form").bootstrapValidator({
					message : 'This value is not valid',
					feedbackIcons : {/* input状态样式图片 */
						valid : 'glyphicon glyphicon-ok',
						invalid : 'glyphicon glyphicon-remove',
						validating : 'glyphicon glyphicon-refresh'
					},
					fields : {
						ISDN : {
							message : 'ISDN无效',
							validators : {
								notEmpty : {
									message : 'ISDN不能为空'
								},
								regexp : {
									regexp : /^[0-9a-zA-Z-_]{8,8}$/,
									message : '请输入8位的ISDN'
								}
							}
						},
						bookName : {
							validators : {
								notEmpty : {
									message : '书名不能为空'
								},
								StringLength : {
									min : 1,
									max : 20,
									message : '书名过长'
								},

							}
						},
						kucun : {
							validators : {
								notEmpty : {
									message : '库存不能为空'
								},
								numeric : {
									message : '库存只能输入数字'
								},
							}
						},
						author : {
							validators : {
								notEmpty : {
									message : '作者不能为空'
								}

							}
						},
						printer : {
							validators : {
								notEmpty : {
									message : '出版社不能为空'
								}

							}
						},
						order : {
							validators : {
								notEmpty : {
									message : '版次不能为空'
								}

							}
						},

					}

				}).on('success.form.bv',function(e) {
							e.preventDefault();
							// 提交
							var picturename = "";
							picturename = $("#inputfile").val().substring(
									$("#inputfile").val().indexOf('.'),
									$("#inputfile").val().length).toUpperCase();
							if (picturename == ".JPG" || picturename == ".PNG"
									|| picturename == ""
									|| picturename == ".BMP"
									|| picturename == ".JPEG") {
								$.ajax({
											type : 'post',
											url : contextPath
													+ '/AdminController/AddBookInfo',
											data : events.queryParams(),
											success : function(data) {
												fishId=$("#ISDN").val();
												// 不上传图片时，不触发bootstrap
												// 上传插件的初始化方法。仅将表单里面的（除图片以外的）内容提交，
												if (data == "1" && $("#inputfile").val() != "") {
													$('#inputfile').fileinput('upload'); // 触发插件开始上传。
												} else {
													alert("ISDN已经存在");
												}
											}
										});
							} else {
								alert("只能上传.jpg，.png，.PNG,.JPG,bmp,jpeg格式的图片");
								return false;
							}

						});
	};
	// 初始化日历
	events.initCanlader = function() {
		$('.form_date').datetimepicker({
			language : 'zh-CN',
			weekStart : 1,
			todayBtn : 1,
			autoclose : 1,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0
		});
	};
	/**
	 * 删除图书校验
	 */
	events.delJiaoYan=function(){
		$("#delBook-form").bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {/* input状态样式图片 */
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				delISDN : {
					message : 'ISDN无效',
					validators : {
						notEmpty : {
							message : 'ISDN不能为空'
						}
					}
				},
			}

		}).on('success.form.bv',function(e) {
			e.preventDefault();
			$.ajax({
				type : 'post',
				url : contextPath+ '/AdminController/DelBook',
				data : {
					ISDN:$("#delISDN").val()},
				success : function(data) {
						if(data=="1"){
							var result=confirm("删除成功");
							if(result){
								$("#delISDN").val('');
								$("#delBook-form").data('bootstrapValidator').resetForm();
							}else{
								$("#delISDN").val('');
								$("#delBook-form").data('bootstrapValidator').resetForm();
							}
						}else{
							alert("输入的ISDN不存在");
						}				
				}		
			}); 
		});
	};
	$(events.init);
})(jQuery);