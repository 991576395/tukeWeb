<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>订单详情</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="plug-in/ace/css/bootstrap.css" />
<script type="text/javascript">
	//编写自定义JS代码
</script>
</head>
<body>
	<div class="list-div" style="border-bottom: none; margin-top: 10px">
		<table width="100%" cellpadding="3" cellspacing="0"
			class="form-horizontal table table-bordered">
			<tr height="50px;">
				<td colspan="3" align="left"
					style="font-size: 25px; text-indent: 1em">订单号：${cvcOrderInfoEntity.orderSn}</td>
				<td colspan="3" align="center" style="padding-top: 15px">
					下单时间：${cvcOrderInfoEntity.addTime}&nbsp;&nbsp; <!-- <input type="button" value="锁定"/>
      <input type="button" value="解锁"/> -->
				</td>
		</table>
	</div>


	<div class="list-div" style="border-top: none; border-bottom: none;">
		<table width="100%" cellpadding="3" cellspacing="0"
			class="table table-bordered">
			<tr>
				<td style="text-indent: 2.5em" colspan="13"><strong>商品情况</strong></td>
			</tr>
			<tr>
				<td scope="col" style="text-indent: 2.5em"><div align="left">商品名称
						[ 品牌 ]</div></td>
				<td scope="col"><div align="center">商品编号</div></td>
				<td scope="col"><div align="center">数量</div></td>
			</tr>

			<c:if test="${fn:length(goods_list) > 0}">
				<c:forEach var="goods" items="${goods_list}">
					<tr>
						<td style="text-indent: 2.5em">
							<div id="suit_${goods.goodsId}">${goods.goodsSn}</div>
						</td>
						<td align="center">${goods.goodsSn}</td>
						<td align="center">${goods.goodsNumber}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<div class="list-div" style="border-top: none; border-bottom: none;">
		<table width="100%" cellpadding="3" cellspacing="0"
			class="table table-bordered">
			<tr>
				<td style="text-indent: 2.5em" colspan="2"><strong>物流情况</strong>
					<hr></td>
			</tr>
			<tr>
				<td style="text-indent: 2.5em" width="10%" valign="top">物流名称：</td>
				<td><select name="shippingName" id="shippingNameSelect"
					onchange="change_shipping()">
						<c:if test="${fn:length(shippingEntitys) > 0}">
							<c:forEach var="shippingEntity" items="${shippingEntitys}">
								<option value="${shippingEntity.shippingName}"
									<c:if test="${shippingEntity.isDefault eq 1}">
															selected="selected"
														</c:if>>${shippingEntity.shippingName}</option>
							</c:forEach>
							<option value="0">其他</option>
						</c:if>
				</select>

					<div style="margin-top: 5px; display: none" id="shipping_name_div">
						<input type="text" width="200px" name="shipping_name"
							placeholder="物流名称" id="shipping_name" disabled="disabled" />
					</div>

					<div style="margin-top: 5px;">
						<input type="text" width="300px" name="invoice_no"
							placeholder="物流单号" id="invoice_no" />
					</div></td>
			</tr>
			<tr>
				<td style="text-indent: 2.5em" width="12%" valign="top">预计送到时间：</td>
				<td><input id="preArrivalDate" name="preArrivalDate"
					type="text" style="width: 200px" class="Wdate"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /></td>
			</tr>
		</table>
	</div>

	<div class="list-div" style="border-top: none;">
		<table cellpadding="3" cellspacing="0" class="table table-bordered">
			<tr height="50px">
				<td style="text-indent: 2.5em" colspan="6" align="left"><strong>当前可执行操作：</strong>
					<input name="delivery_confirmed" type="button" value="发货并生成对账单"
					class="btn btn-primary btn-sm"
					onclick="send(${cvcOrderInfoEntity.id});" />&nbsp;&nbsp; <input
					type="button" value="取消 " class="btn btn-danger btn-sm"
					onclick="location.href='cvcOrderInfo.do?toDetail&id=${cvcOrderInfoEntity.id}'" />

					<input name="order_id" type="hidden"
					value="${cvcOrderInfoEntity.id}"></td>
			</tr>
		</table>
	</div>
</body>

<script type="text/javascript">
	//点击发货
	function send(order_id) {
		layer.open({
			title : "系统提示",
			content : "确认发货？",
			icon : 7,
			shade : 0.3,
			yes : function(index) {
				request('cvcOrderInfo.do?ship&orderId=' + order_id
						+ '&invoiceNo=' + $("#invoice_no").val()
						+ '&shippingName=' + $("#shippingNameSelect").val()
						+ '&preArrivalDate=' + $("#preArrivalDate").val(),
						function(d) {
							window.location.href= 'cvcOrderInfo.do?toDetail&id='+order_id;
							//发货成功检查发货消息
							//checkSize();
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
			type : 'post',
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
	
	function tipAlert(title,id){
		layer.open({
			title:"系统提示",
			content:title,
			icon:7,
			shade: 0.3,
			yes:function(index){
				layer.close(index);
				//修改已读
				requestNew("cvcMessageTableController.do?setRead&id="+id,function(data){
				});
			},
			btn:['已读','忽略'],
			btn2:function(index){
				layer.close(index);
			}
		});
	}
		
	//请求
	function requestNew(url, fn) {
		$.ajax({
			url : url,
			type : 'post',
			cache : false,
			success : function(data) {
				var d = $.parseJSON(data);
				var msg = d.msg;
				if (d.success) {
					fn.call(this,d);
				}
			}
		});
	}
  
  function checkSize(){
	//判断是否需要提示信息
		requestNew("cvcInventoryTableController.do?checkIfWillAlter",function(data){
			if(data.obj.length > 0){
				for(var i = 0 ;i < data.obj.length; i++){
					tipAlert(data.obj[0].messageContent,data.obj[0].id);
				}
			}
		});
  }
	
	//选择物流
	  function change_shipping(){
	      document.getElementById("shipping_name").value = '';
	      document.getElementById("invoice_no").value = '';
	      if($('#shippingNameSelect  option:selected').val() == '0'){
	          document.getElementById("shipping_name_div").style.display = '';
	          document.getElementById("shipping_name").disabled = '';
	      }else{
	    	  document.getElementById("shipping_name_div").style.display = 'none';
	          document.getElementById("shipping_name").disabled ='disabled';
	      }
	  }
</script>
</html>