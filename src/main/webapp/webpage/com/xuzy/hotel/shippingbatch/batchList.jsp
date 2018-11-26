<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="菜名维护" actionUrl="cvcShippingBatch.do?datagrid"  queryMode="group" pageSize="15" idField="id" fit="true">
   <t:dgCol title="id" field="id"  hidden="true"></t:dgCol>
   <t:dgCol title="上传批次号" field="batchNo"  queryMode="single" query="true"  width="80"></t:dgCol>
   <t:dgCol title="订单批次号" field="orderBatchNo"   width="80"></t:dgCol>
   <t:dgCol title="批量上传时间" field="addTimeFormat" ></t:dgCol>
   <t:dgCol title="发货总量" field="shippingCount"   width="80"></t:dgCol>
   <t:dgCol title="成功数量" field="shippingCountOk" ></t:dgCol>
   <t:dgCol title="未上传数量" field="shippingCountNot" ></t:dgCol>
   <t:dgCol title="是否存在非本订单批次号的订单"  field="msgStatusStr"  ></t:dgCol>
	<t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgDelOpt title="删除" url="cvcShippingBatch.do?doDel&batchNo={batchNo}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgFunOpt title="查看详情"   urlclass="ace_button" urlfont="fa-search"  funname="goLook(batchNo)"/>
   
  <t:dgToolBar title="上传发货excel" icon="icon-put" url="cvcShippingBatch.do?toUpload" width="600" height="300" funname="add" ></t:dgToolBar>
  </t:datagrid>
  </div>
  
  <script type="text/javascript">
			function goLook(batchNo) {
				var url = 'cvcShippingBatchOrder.do?toList&batchNo='+batchNo;
				toLoadNewTab("批量发货订单列表",url);
			}
			
			/* function toUpload(){
				var url = 'cvcShippingBatchOrder.do?toUpload';
				toLoadNewTab("上传发货excel",url);
			} */
			
			function toLoadNewTab(title,url) {
				var label = title;
				var h = url,
				m = 0;
				parent.addIframeMy(h,m,label);
			}
			
			
			
			
		</script>
 </div>