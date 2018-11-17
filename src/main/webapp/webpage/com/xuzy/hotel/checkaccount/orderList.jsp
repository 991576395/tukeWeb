<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  	<t:datagrid name="tOrderList" title="对账订单" actionUrl="cvcCheckingAccountOrder.do?datagrid&checkingAccountId=${checkingAccountId}"  queryMode="group" pageSize="15" idField="id" fit="true">
   	<t:dgCol title="编号" field="id"   width="80"></t:dgCol>
   	<t:dgCol title="对账表头ID" field="checkingAccountId" defaultVal="${checkingAccountId}"  width="80"></t:dgCol>
   	<t:dgCol title="订单号" field="orderId"  query="true" queryMode="single"  width="80"></t:dgCol>
   	<t:dgCol title="礼品编号" field="goodsSn"  width="100"></t:dgCol>
  	<t:dgCol title="快递公司" field="shippingName"  width="120"></t:dgCol>
   	<t:dgCol title="快递单号" field="invoiceNo" query="true" queryMode="single"  width="100"></t:dgCol>
   	<t:dgCol title="状态" field="statueName"  width="120"></t:dgCol>
   	<t:dgCol title="上传时间" field="addCheckingAccountTimeFormat" width="120"></t:dgCol>
   	<t:dgCol title="上传状态" field="isAddCheckingAccount" hidden="true" query="true" queryMode="single" dictionary="upstatus"  width="120"></t:dgCol>
   	
   	
   	<t:dgToolBar title="上传对账明细" icon="icon-putout" url="cvcCheckingAccountOrder.do?addCheckingAccount" width="800" height="400" funname="add"></t:dgToolBar>
   	<t:dgToolBar title="重新生成对账明细" icon="icon-search" url="cvcCheckingAccount.do?toDetail" width="1200" height="800" funname="goLook"></t:dgToolBar>
 	<t:dgToolBar title="封账" icon="icon-add" url="cvcCheckingAccount.do?toAdd" width="800" height="400" funname="add"></t:dgToolBar>
 	<t:dgToolBar title="导出EXCEL" icon="icon-add" url="cvcCheckingAccount.do?toAdd" width="800" height="400" funname="add"></t:dgToolBar>
  </t:datagrid>
  </div>
  
  <script type="text/javascript">
			//单元格的格式化函数  value：字段的值 row：行的记录数据 index：行的索引
			  function formatAgeFun(age,row,index){
			  	if(age == 0){
			  		return "";
			  	}
			  	return age;
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