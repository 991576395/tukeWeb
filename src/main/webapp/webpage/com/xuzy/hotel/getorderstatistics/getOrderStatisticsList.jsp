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
		   <t:dgCol title="抓单时间" field="addTimeFormat"   width="160"></t:dgCol>
		   <t:dgCol title="待配货" field="waitDeliveryCount"  url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=1" funname="toLoadNewTab"   width="80"></t:dgCol>
		   <t:dgCol title="配货中" field="deliveryCount"  url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=2" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="离港中" field="offharbourCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=3" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="配送中" field="sendCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=4" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="已签收" field="signinCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=5" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="异常订单(未处理)" field="exceptionCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&exceptionStatus=2&isShow=1" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="异常订单(已处理)" field="exceptionDoCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&exceptionStatus=2&isShow=2" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="签收失败" field="signinFailCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=6" funname="toLoadNewTab"   width="70"></t:dgCol>
		   <t:dgCol title="退货订单" field="backCount" url="cvcOrderInfo.do?list&batchNo=#{unifiedBatchNo}&orderStatus=7" funname="toLoadNewTab"   width="70"></t:dgCol>
	 		
	 		<t:dgCol title="操作" field="opt" width="200"></t:dgCol>
	 		<t:dgFunOpt title="分表导出"   urlclass="ace_button" urlfont="fa-file-excel-o"  funname="excelOut(unifiedBatchNo)"/>
			<t:dgFunOpt title="汇总导出"   urlclass="ace_button" urlfont="fa-file-excel-o"  funname="excelAll(unifiedBatchNo)"/>
	  </t:datagrid>
  </div>
  
  <script type="text/javascript">
			function toLoadNewTab(title,url) {
				var label = title;
				var h = url,
				m = 0;
				parent.addIframeMy(h,m,label);
			}
			
			
			//导出文件
			function excelAll(unifiedBatchNo){
				var url = "cvcOrderInfo.do?exportXls";
				if (unifiedBatchNo != 'undefined' && unifiedBatchNo.length > 0) {
					url+="&batchNo="+unifiedBatchNo;
				}
				window.location.href=url;
			}
			
			//导出文件
			function excelOut(unifiedBatchNo){
				var url = "cvcOrderInfo.do?exportXlsByGoodType";
				if (unifiedBatchNo != 'undefined' && unifiedBatchNo.length > 0) {
					url+="&batchNo="+unifiedBatchNo;
				}
				window.location.href=url;
			}
			
  </script>
</div>