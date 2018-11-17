<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css"
		type="text/css"></link>
	<script type="text/javascript"
		src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
	<script type="text/javascript" src="plug-in/tools/Map.js"></script>
	<script type="text/javascript">
	var flag = false;
	var fileitem="";
	var fileKey="";
	var serverMsg="";
	var m = new Map();
	$(function(){
	$('#testFile1').uploadify({buttonText:'浏览',auto:false,progressData:'speed',multi:true,height:25,overrideEvents:['onDialogClose'],fileTypeDesc:'文件格式:',queueID:'filediv_testFile1',fileTypeExts:'',fileSizeLimit:'15MB',swf:'plug-in/uploadify/uploadify.swf',	uploader:'tMenuTableController.do?save&sessionId=1sr8rkrdxzv3g15rbyiks45t66',onUploadStart : function(file) { var id=$('#id').val();var dish=$('#dish_name').val();var classfryid=$('#classfryid').val();var uploadifystorage=$('#uploadifystorage_number').val();var decription=$('#decription').val();$('#testFile1').uploadify("settings", "formData", {'id':id,'dish':dish,'classfryid':classfryid,'uploadifystorage':uploadifystorage,'decription':decription});} ,onQueueComplete : function(queueData) { var win = frameElement.api.opener;win.reloadTable();win.tip(serverMsg);if(subDlgIndex && $('#infoTable-loading')){$('#infoTable-loading').hide();if(!subDlgIndex.closed)subDlgIndex.close();}frameElement.api.close();$("#viewmsg").html(m.toString());$("#fileKey").val(fileKey);},onUploadSuccess : function(file, data, response) {var d=$.parseJSON(data);var fileitem="<span id='"+d.attributes.id+"'><a href='#' onclick=openwindow('文件查看','"+d.attributes.viewhref+"','70%','80%') title='查看'>"+d.attributes.name+"</a><img border='0' onclick=confuploadify('"+d.attributes.delurl+"','"+d.attributes.id+"') title='删除' src='plug-in/uploadify/img/uploadify-cancel.png' widht='15' height='15'>&nbsp;&nbsp;</span>"; m=new Map(); m.put(d.attributes.id,fileitem);fileKey=d.attributes.fileKey;if(d.success){var win = frameElement.api.opener;serverMsg = d.msg;}},onFallback : function(){tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")},onSelectError : function(file, errorCode, errorMsg){switch(errorCode) {case -100:tip("上传的文件数量已经超出系统限制的"+$('#testFile1').uploadify('settings','queueSizeLimit')+"个文件！");break;case -110:tip("文件 ["+file.name+"] 大小超出系统限制的"+$('#testFile1').uploadify('settings','fileSizeLimit')+"大小！");break;case -120:tip("文件 ["+file.name+"] 大小异常！");break;case -130:tip("文件 ["+file.name+"] 类型不正确！");break;}},onUploadProgress : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) { }});});function upload() {	$('#testFile1').uploadify('upload', '*');return flag;}function cancel() {$('#testFile1').uploadify('cancel', '*');}</script>
	<span id="testFile1span"><input type="file" name="testFile1"
		id="testFile1" /></span>
	<span id="viewmsg"></span>
	<input type="hidden" name="fileKey" id="fileKey" />
</body>
</html>