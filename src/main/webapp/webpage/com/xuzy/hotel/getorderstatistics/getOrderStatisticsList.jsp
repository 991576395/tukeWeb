<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" src="plug-in/themes/fineui/common/js/sccl.js"></script>
<script type="text/javascript" src="plug-in/themes/fineui/common/js/sccl-util.js"></script>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="抓单统计" actionUrl="cvcGetOrderStatistics.do?datagrid"  queryMode="group" pageSize="15" idField="id" fit="true">
  	<t:dgCol title="主键"  field="id"  hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="订单批次" field="unifiedBatchNo"  width="80"></t:dgCol>
   <t:dgCol title="订单数量" field="orderCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}" funname="toLoadNewTab"  width="80"></t:dgCol>
   <t:dgCol title="抓单时间" field="addTimeFormat"   width="80"></t:dgCol>
   <t:dgCol title="待配货" field="waitDeliveryCount"  url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=1" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="配货中" field="deliveryCount"  url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=2" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="离港中" field="offharbourCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=3" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="配送中" field="sendCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=4" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="已签收" field="signinCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=5" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="异常订单" field="exceptionCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=1" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="签收失败" field="signinFailCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=6" funname="toLoadNewTab"   width="80"></t:dgCol>
   <t:dgCol title="退货订单" field="backCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=7" funname="toLoadNewTab"   width="80"></t:dgCol>
  </t:datagrid>
  </div>
  
  <script type="text/javascript">
			function toLoadNewTab(title,url) {
				var label = title;
// 				if(title == "订单数量"){
// 					label = '订单列表';
// 				}else if(title == "待配货"){
// 					label = '订单列表';
// 				}else if(title == "配货中"){
// 					label = '配货中订单';
// 				}else if(title == "离港中"){
// 					label = '配货中订单';
// 				}
				
				var h = url,
				m = 0;
				parent.addIframeMy(h,m,label);
			}

		</script>
 </div>