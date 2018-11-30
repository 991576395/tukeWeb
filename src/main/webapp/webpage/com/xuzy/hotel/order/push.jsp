<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>推送订单</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<link rel="stylesheet" href="plug-in/ace/css/bootstrap.css" />
</head>
<body>
	<form class="form-horizontal"
		style="margin-top: 30px; margin-bottom: 30px">
		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">订单号:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" id="orderId"
					placeholder="请输入操作订单号 ">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input name="delivery_confirmed" type="button" value="推送至离港"
					class="btn btn-primary btn-sm"
					onclick="toUpdate('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=offharbour')" />
				<input name="delivery_confirmed" type="button" value="推送至配送中"
					class="btn btn-primary btn-sm"
					onclick="toUpdate('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=send')" />
				<input name="delivery_confirmed" type="button" value="推送至签收"
					class="btn btn-primary btn-sm"
					onclick="toUpdate('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=signin')" />
			</div>
		</div>
	</form>
</body>

<script type="text/javascript">
	//编写自定义JS代码
	function toUpdate(url) {
		var rowsData = $('#orderId').val();
		if (typeof rowsData == "undefined" || rowsData == null || rowsData == "") {
			tip('请输入操作的订单号！');
			return;
		}
		url += '&id=' + rowsData;
		layer.open({
			title : "系统提示",
			content : "确认操作？",
			icon : 7,
			shade : 0.3,
			yes : function(index) {
				request(url, function(d) {
				});
			},
			btn : [ '确定', '取消' ],
			btn2 : function(index) {
				layer.close(index);
			}
		});
	}

	//请求
	function request(url, fn) {
		$.ajax({
			url : url,
			type : 'get',
			cache : false,
			success : function(data) {
				var d = $.parseJSON(data);
				var msg = d.msg;
				tip(msg);
				if (d.success) {
					fn.call(d);
				}
			}
		});
	}
</script>