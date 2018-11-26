<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>客户端版本表</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<link rel="stylesheet" href="plug-in/ace/css/bootstrap.css" />

<script type="text/javascript">


  //编写自定义JS代码
  </script>
</head>
<body>
	<!-- 订单搜索 -->
	<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcShippingBatch.do?importExcel" >
	<!-- <form method="post" action="cvcShippingBatch.do?importExcel"
		name="listForm" enctype="multipart/form-data">
 -->		
 		<div class="form-group">
			<label for="file_excel">上传文件:</label>
			  <input type="file"
				id="file_excel" name="file_excel">
		</div>

		<div class="form-group">
			<label for="order_batch_no">订单批次号</label> <input type="text"
				class="form-control" name="order_batch_no" id="order_batch_no"
				size="30" placeholder="订单批次号">
		</div>
		<br>
	<!-- </form> -->
	</t:formvalid>
</body>