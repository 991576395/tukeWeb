<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="异常订单列表" actionUrl="cvcOrderInfo.do?exceptionOrderListDatagrid"  queryMode="group" pageSize="15" idField="id" fit="true">
   <t:dgCol title="订单批次" field="batchNo"  queryMode="single" query="true"  width="80"></t:dgCol>
   <t:dgCol title="礼品编号" field="goodsSn"   width="80"></t:dgCol>
   <t:dgCol title="订单号" field="id" queryMode="single"  query="true"   width="80"></t:dgCol>
   <t:dgCol title="收货人" field="consignee"   width="80"></t:dgCol>
   <t:dgCol title="订单状态" field="orderStatus" queryMode="single" dictionary="OStatus"  width="100"></t:dgCol>
   <t:dgCol title="伊利订单状态" field="ylOrderStatus" queryMode="single" dictionary="OStatus"   width="120"></t:dgCol>
   <t:dgCol title="快递公司" field="shippingId" queryMode="single" dictionary="cvc_shipping where enabled = '1',shipping_id,shipping_name" query="true"  width="100"></t:dgCol>
   <t:dgCol title="快递单号" field="invoiceNo" queryMode="single"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="异常信息" field="exceptionStatus" queryMode="single" dictionary="extype"  query="true"  width="70"></t:dgCol>
   <t:dgCol title="异常生成时间" field="addTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="处理状态" field="handleStatus" dictionary="dostatus" queryMode="single"  query="true"   width="120"></t:dgCol>
   <t:dgCol title="处理时间" field="HandleTimeFormat"   width="120"></t:dgCol>
   <t:dgCol title="操作人" field="handleUser"  width="80"></t:dgCol>
   <t:dgToolBar title="查看详情" icon="icon-search" url="cvcOrderInfo.do?toDetail" width="1200" height="800" funname="goLook"></t:dgToolBar>
  </t:datagrid>
  </div>
  
  <script type="text/javascript">

			function goLook(title, url, id, width, height, isRestful) {
				gridname = id;
				var rowsData = $('#' + id).datagrid('getSelections');
				if (!rowsData || rowsData.length == 0) {
					tip('请选择查看项目');
					return;
				}
				if (rowsData.length > 1) {
					tip('请选择一条记录再查看');
					return;
				}
				if (isRestful != 'undefined' && isRestful) {
					url += '/' + rowsData[0].id;
				} else {
					url += '&id=' + rowsData[0].id;
				}
// 				window.location.href= url;  
// 				window.open(url,"_blank");
				createMywindow(title, url, width, height);
			}

			function createMywindow(title, addurl, width, height) {
				width = width ? width : 700;
				height = height ? height : 400;
				if (width == "100%" || height == "100%") {
					width = window.top.document.body.offsetWidth;
					height = window.top.document.body.offsetHeight - 100;
				}
				$.dialog({
					content : 'url:' + addurl,
					lock : true,
					zIndex : getzIndex(),
					width : width,
					height : height,
					title : title,
					opacity : 0.3,
					cache : false,
					cancelVal : '关闭',
					cancel : true
				/*为true等价于function(){}*/
				});
			}
		</script>
 </div>