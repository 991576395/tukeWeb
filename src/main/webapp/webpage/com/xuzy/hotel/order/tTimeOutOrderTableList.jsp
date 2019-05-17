<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="异常订单列表" actionUrl="cvcOrderInfo.do?timeOutOrderListDatagrid"  queryMode="group" pageSize="15" idField="id" fit="true">
   <t:dgCol title="订单号" field="id" queryMode="single"    width="80"></t:dgCol>
   <t:dgCol title="订单状态" field="orderStatus" queryMode="single" dictionary="OStatus"  width="100"></t:dgCol>
   <t:dgCol title="快递公司" field="shippingId" queryMode="single" dictionary="cvc_shipping where enabled = '1',shipping_id,shipping_name"  width="100"></t:dgCol>
   <t:dgCol title="快递单号" field="invoiceNo" queryMode="single"   width="120"></t:dgCol>
   <t:dgCol title="离发货时间" field="timeOutValue"   width="120"></t:dgCol>
   <t:dgCol title="最近一条物流信息" field="newDeleveryInfo"   width="300"></t:dgCol>
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
			
			//导出
			  function ExportXls() {
				var batchNo =  $("input[name='batchNo']").val();
				var id =  $("input[name='id']").val();
				var shippingId =  $("select[name='shippingId']").val();
				var invoiceNo =  $("input[name='invoiceNo']").val();
				var exceptionStatus =  $("select[name='exceptionStatus']").val();
				var handleStatus =  $("select[name='handleStatus']").val();
				
				var url = "cvcOrderInfo.do?exportExceptionEXls";
				if (batchNo != 'undefined' && batchNo.length > 0) {
					url+="&batchNo="+batchNo;
				}
				if (id != 'undefined' && id.length > 0) {
					url+="&id="+id;
				}
				if (shippingId != 'undefined' && shippingId.length > 0) {
					url+="&shippingId="+shippingId;
				}
				if (invoiceNo != 'undefined' && invoiceNo.length > 0) {
					url+="&invoiceNo="+invoiceNo;
				}
				if (exceptionStatus != 'undefined' && exceptionStatus.length > 0) {
					url+="&exceptionStatus="+exceptionStatus;
				}
				if (handleStatus != 'undefined' && handleStatus.length > 0) {
					url+="&handleStatus="+handleStatushandleStatus;
				}
				window.location.href=url;
			  }	 
		</script>
 </div>