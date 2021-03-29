<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>客户端版本表</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	crossorigin="anonymous">
<link href="plug-in/fileinput/css/fileinput.css" media="all"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	crossorigin="anonymous">
<link href="plug-in/fileinput/themes/explorer-fas/theme.css" media="all"
	rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="plug-in/fileinput/js/plugins/piexif.js"
	type="text/javascript"></script>
<script src="plug-in/fileinput/js/plugins/sortable.js"
	type="text/javascript"></script>
<script src="plug-in/fileinput/js/fileinput.js" type="text/javascript"></script>
<script src="plug-in/fileinput/js/locales/fr.js" type="text/javascript"></script>
<script src="plug-in/fileinput/js/locales/es.js" type="text/javascript"></script>
<script src="plug-in/fileinput/themes/fas/theme.js"
	type="text/javascript"></script>
<script src="plug-in/fileinput/themes/explorer-fas/theme.js"
	type="text/javascript"></script>


<script type="text/javascript">
	//编写自定义JS代码

	// 上传附件
	$("#input-ke-2").fileinput({
		language : 'zh', // 多语言设置，需要引入local中相应的js，例如locales/zh.js
		theme : "explorer-fa", // 主题
		uploadUrl : "cvcShippingBatch.do?importExcel", // 上传地址
		minFileCount : 1, // 最小上传数量
		maxFileCount : 5, // 最大上传数量
		overwriteInitial : false, // 覆盖初始预览内容和标题设置
		showCancel : false, // 显示取消按钮
		showZoom : false, // 显示预览按钮
		showCaption : false, // 显示文件文本框
		dropZoneEnabled : false, // 是否可拖拽
		uploadLabel : "上传附件", // 上传按钮内容
		browseLabel : '选择附件', // 浏览按钮内容
		showRemove : false, // 显示移除按钮
		browseClass : "layui-btn", // 浏览按钮样式
		uploadClass : "layui-btn", // 上传按钮样式
		uploadExtraData : {
			'order_batch_no' : $("#order_batch_no").val(),
		}, // 上传数据
		hideThumbnailContent : true, // 是否隐藏文件内容
		fileActionSettings : { // 在预览窗口中为新选择的文件缩略图设置文件操作的对象配置
			showRemove : true, // 显示删除按钮
			showUpload : true, // 显示上传按钮
			showDownload : false, // 显示下载按钮
			showZoom : false, // 显示预览按钮
			showDrag : false, // 显示拖拽
			removeIcon : '<i class="fa fa-trash"></i>', // 删除图标 
			uploadIcon : '<i class="fa fa-upload"></i>', // 上传图标
			uploadRetryIcon : '<i class="fa fa-repeat"></i>' // 重试图标
		}

	/*, initialPreview : [ //初始预览内容
	"https://picsum.photos/1920/1080?image=101",
			"https://picsum.photos/1920/1080?image=102",
			"https://picsum.photos/1920/1080?image=103" ],
	initialPreviewConfig : [ // 初始预览配置 caption 标题，size文件大小 ，url 删除地址，key删除时会传这个
	{
		caption : "picture-1.jpg",
		size : 329892,
		width : "120px",
		url : task_file_delete_url,
		key : 101
	}, {
		caption : "picture-2.jpg",
		size : 872378,
		width : "120px",
		url : task_file_delete_url,
		key : 102
	}, {
		caption : "picture-3.jpg",
		size : 632762,
		width : "120px",
		url : task_file_delete_url,
		key : 103
	} ] */
	});
	// 上传成功回调
	$("#input-ke-2").on("filebatchuploadcomplete", function() {
		layer.msg("上传附件成功");
		setTimeout("closeUpladLayer()", 2000)
	});
	// 上传失败回调
	$('#input-ke-2').on('fileerror', function(event, data, msg) {
		layer.msg(data.msg);
		tokenTimeOut(data);
	});
</script>
</head>
<body>
	<!-- 订单搜索 -->
	<form  >
	<!-- <form method="post" action="cvcShippingBatch.do?importExcel"
		name="listForm" enctype="multipart/form-data">
 -->		
 		<div class="form-group">
			<label for="file_excel">上传文件:</label>
			 <div >
			    <input id="input-ke-2" name="file" type="file" multiple>
			</div>
		</div>

		<div class="form-group">
			<label for="order_batch_no">订单批次号</label> <input type="text"
				class="form-control" name="order_batch_no" id="order_batch_no"
				size="30" placeholder="订单批次号">
		</div>
		<br>
	<!-- </form> -->
	</form>
</body>