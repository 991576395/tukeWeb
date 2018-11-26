<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="菜名维护" actionUrl="cvcOrderInfo.do?datagrid"  queryMode="group" pageSize="15" idField="id" fit="true">
   <t:dgCol title="订单批次" field="batchNo"  queryMode="single" query="true" defaultVal="${batchNo}"  width="80"></t:dgCol>
   <t:dgCol title="礼品编号" field="goodsSn"   width="80"></t:dgCol>
   <t:dgCol title="订单号" field="id" queryMode="single"  query="true"   width="80"></t:dgCol>
   <t:dgCol title="收货人" field="consignee"   width="80"></t:dgCol>
   <t:dgCol title="订单状态" field="orderStatus" queryMode="single" dictionary="OStatus" defaultVal="${orderStatus}"  query="true"  width="100"></t:dgCol>
   <t:dgCol title="伊利订单状态" field="ylOrderStatus" queryMode="single" dictionary="OStatus"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="快递公司" field="shippingId" queryMode="single" dictionary="cvc_shipping where enabled = '1',shipping_id,shipping_name" query="true"  width="100"></t:dgCol>
   <t:dgCol title="快递单号" field="invoiceNo" queryMode="single"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="是否异常" field="exceptionStatus" queryMode="single" dictionary="isExp"  query="true"  width="70"></t:dgCol>
   <t:dgCol title="下单时间" field="addTime" formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="抓单时间" field="getTime" formatter="yyyy-MM-dd hh:mm:ss"  width="120"></t:dgCol>
   <t:dgCol title="结算标识" field="isBalance"  queryMode="single" dictionary="is_balance"   query="true"  width="120"></t:dgCol>
   <t:dgCol title="积分账户" field="userName" queryMode="single" dictionary="atType"   query="true"  width="80"></t:dgCol>
<%--    <c:if test="${orderStatus == 7}"> --%>
   		<t:dgCol title="退货原因" field="returnReason" queryMode="single" dictionary="rtReason"  query="true"  width="120"></t:dgCol>
<%--    </c:if> --%>

   <t:dgToolBar title="查看详情" icon="icon-search" url="cvcOrderInfo.do?toDetail" width="1000" height="600" funname="goLook"></t:dgToolBar>
   
   <t:dgToolBar title="导出EXCEL" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="推送至离港" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=offharbour"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="推送至配送中" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=send"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="推送至签收" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=signin"  funname="toUpdate"></t:dgToolBar>
  	
  
  </t:datagrid>
  </div>
  
  <script type="text/javascript">
		//导出
		  function ExportXls() {
			var batchNo =  $("input[name='batchNo']").val();
			var id =  $("input[name='id']").val();
			var orderStatus =  $("select[name='orderStatus']").val();
			var ylOrderStatus =  $("select[name='ylOrderStatus']").val();
			var shippingId =  $("select[name='shippingId']").val();
			var invoiceNo =  $("input[name='invoiceNo']").val();
			var exceptionStatus =  $("select[name='exceptionStatus']").val();
			var addTime_begin1 =  $("input[name='addTime_begin1']").val();
			var addTime_end2 =  $("input[name='addTime_end2']").val();
			var isBalance =  $("select[name='isBalance']").val();
			var userName =  $("select[name='userName']").val();
			var returnReason =  $("select[name='returnReason']").val();
			
			var url = "cvcOrderInfo.do?exportXls";
			if (batchNo != 'undefined' && batchNo.length > 0) {
				url+="&batchNo="+batchNo;
			}
			if (id != 'undefined' && id.length > 0) {
				url+="&id="+id;
			}
			if (orderStatus != 'undefined' && orderStatus.length > 0) {
				url+="&orderStatus="+orderStatus;
			}
			if (ylOrderStatus != 'undefined' && ylOrderStatus.length > 0) {
				url+="&ylOrderStatus="+ylOrderStatus;
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
			if (addTime_begin1 != 'undefined' && addTime_begin1.length > 0) {
				url+="&addTime_begin1="+addTime_begin1;
			}
			if (addTime_end2 != 'undefined' && addTime_end2.length > 0) {
				url+="&addTime_end2="+addTime_end2;
			}
			if (isBalance != 'undefined' && isBalance.length > 0) {
				url+="&isBalance="+isBalance;
			}
			if (userName != 'undefined' && userName.length > 0) {
				url+="&userName="+userName;
			}
			if (returnReason != 'undefined' && returnReason.length > 0) {
				url+="&returnReason="+returnReason;
			}
			window.location.href=url;
		  }	  	
  
		  function toUpdate(title, url, id, width, height, isRestful) {
			  	var rowsData = $('#' + id).datagrid('getSelections');
				if (!rowsData || rowsData.length == 0) {
					tip('请选择操作订单');
					return;
				}
				if (rowsData.length > 1) {
					tip('请选择一条订单再操作');
					return;
				}
				if (isRestful != 'undefined' && isRestful) {
					url += '/' + rowsData[0].id;
				} else {
					url += '&id=' + rowsData[0].id;
				} 
			  
				layer.open({
					title:"系统提示",
					content:"确认操作？",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request(url,function (d){
							reloadTable();
						});
					},
					btn:['确定','取消'],
					btn2:function(index){
						layer.close(index);
					}
				}); 
			}
  			
		  	//请求
			function request(url,fn){
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