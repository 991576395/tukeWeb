<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>



<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
   <t:datagrid name="tGetOrderList" title="抓单统计" actionUrl="cvcGetOrderStatistics.do?getOrderData"  queryMode="group" pageSize="15" idField="id" fit="true">
   	<t:dgCol title="订单批次" field="batchNo"  width="80"></t:dgCol>
  	<t:dgCol title="订单号" field="id"  width="80"></t:dgCol>
  	<t:dgCol title="用户ID" field="userId"  width="80"></t:dgCol>
  	<t:dgCol title="下单时间" field="addTime"  width="80"></t:dgCol>
  	<t:dgCol title="收货人" field="consignee"  width="80"></t:dgCol>
  	<t:dgCol title="积分账户" field="userName"  width="80"></t:dgCol>
<%--   	<t:dgCol title="订单详情" field="userName"  width="80"></t:dgCol> --%>
  	<t:dgToolBar title="抓单" icon="icon-add"  funname="goLoad"></t:dgToolBar>
  	<t:dgToolBar title="确认订单" icon="icon-put"  funname="request"></t:dgToolBar>
  </t:datagrid>
  </div>
 
 </div>
 
  <script type="text/javascript">
			function goLoad() {
						$('#tGetOrderList').datagrid({
								url : 'cvcGetOrderStatistics.do?getOrderData&ifLoad=1&field=id,batchNo,userId,addTime,consignee,userName,',
								pageNumber : 1
						});
			}
			
			//请求
			function request() {
				var value = $('.datagrid-cell-c2-batchNo').html();
				if(value === undefined){
					tip('暂无可确认订单');
				}else{
					$.ajax({
						url : 'cvcGetOrderStatistics.do?setOrderRead&batchNo='+value,
						type : 'post',
//	 					data : {orderId:$("#orderId").val()},
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
			}
		</script>