<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="对账明细主题" actionUrl="cvcCheckingAccount.do?datagrid"  queryMode="group" pageSize="15" idField="checkingAccountId" fit="true">
   <t:dgCol title="ID" field="checkingAccountId"   width="80"></t:dgCol>
   <t:dgCol title="对账明细主题" field="topic"   width="80"></t:dgCol>
   <t:dgCol title="对账开始时间" field="startTime"   width="80"></t:dgCol>
   <t:dgCol title="对账截止时间" field="endTime"  width="100"></t:dgCol>
   <t:dgCol title="积分账户" field="accountType" formatterjs="formatAgeFun"  width="120"></t:dgCol>
   <t:dgCol title="对账生成时间" field="addTimeFormat"  width="100"></t:dgCol>
   <t:dgCol title="是否封账" field="isBalance" dictionary="isBalance"  width="120"></t:dgCol>
   
   <t:dgToolBar title="生成对账表头" icon="icon-add" url="cvcCheckingAccount.do?toAdd" width="800" height="400" funname="add"></t:dgToolBar>
   <t:dgToolBar title="订单列表" icon="icon-search" url="cvcCheckingAccountOrder.do?list" funname="toLoadNewTab"></t:dgToolBar>
   <t:dgToolBar title="删除对账表头" icon="icon-remove" url="cvcCheckingAccount.do?doDelete" funname="remove"></t:dgToolBar>
  </t:datagrid>
  </div>
  
  <script type="text/javascript">
		  function toLoadNewTab(title,url,id, width, height, isRestful) {
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
					url += '/' + rowsData[0].checkingAccountId;
				} else {
					url += '&checkingAccountId=' + rowsData[0].checkingAccountId;
				}
			  
				var label = title;
// 				var h = url+'&checkingAccountId='+id,
				m = 0;
				parent.addIframeMy(url,m,label);
			}
  
			//单元格的格式化函数  value：字段的值 row：行的记录数据 index：行的索引
			  function formatAgeFun(age,row,index){
			  	if(age == 0){
			  		return "";
			  	}else if(age == 1){
			  		return "金领冠";
			  	}else if(age == 2){
			  		return "托菲尔";
			  	}
			  	return age;
			  }		
  
  
			function remove(title, url, id, width, height, isRestful) {
				gridname = id;
				var rowsData = $('#' + id).datagrid('getSelections');
				if (!rowsData || rowsData.length == 0) {
					tip('请选择删除项目');
					return;
				}
				if (rowsData.length > 1) {
					tip('请选择一条记录再删除');
					return;
				}
				if (isRestful != 'undefined' && isRestful) {
					url += '/' + rowsData[0].checkingAccountId;
				} else {
					url += '&id=' + rowsData[0].checkingAccountId;
				}
				createMywindow(title, url, width, height,rowsData[0].checkingAccountId);
			}

			function createMywindow(title, url, width, height,id) {
				layer.open({
					title:"系统提示",
					content:"确认删除对账表头？",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request(url,function (d){
							reloadTable();
// 							removeIt(id);
// 							$('#tOrderList').datagrid({
// 								url : 'cvcGetOrderStatistics.do?getOrderData&ifLoad=1&field=id,batchNo,userId,addTime,consignee,userName,',
// 								pageNumber : 1
// 							});
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
		</script>
 </div>