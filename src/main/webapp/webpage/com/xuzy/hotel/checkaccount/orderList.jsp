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
   	
   	
   	<t:dgToolBar title="上传对账明细" icon="icon-putint" url="cvcCheckingAccountOrder.do?addCheckingAccount&checkingAccountId=${checkingAccountId}"  funname="addCheckingAccount"></t:dgToolBar>
   	<t:dgToolBar title="重新生成对账明细" icon="icon-edit"   onclick="doMyGo('cvcCheckingAccount.do?updateCheckingAccountOrder&checkingAccountId=${checkingAccountId}')"></t:dgToolBar>
 	<t:dgToolBar title="封账" icon="icon-add" onclick="doMyGo('cvcCheckingAccount.do?makeBalance&checkingAccountId=${checkingAccountId}')"></t:dgToolBar>
 	<t:dgToolBar title="导出EXCEL" icon="icon-putout" onclick="exportEXCEL('cvcCheckingAccountOrder.do?exportXls&checkingAccountId=${checkingAccountId}')"></t:dgToolBar>
 	<t:dgToolBar title="删除" icon="icon-remove" url="cvcCheckingAccountOrder.do?doDelete&id=${checkingAccountId}" funname="deleteOrder" ></t:dgToolBar>
 
  </t:datagrid>
  </div>
  
  
  <script type="text/javascript">
	  	function exportEXCEL(url) {
			 window.location.href=url;
		}
  
  
  		var sucSize = 0;
  			function addCheckingAccount(title, url){
  				/* $.dialog.setting.zIndex = getzIndex(true);
  				$.dialog({
  						title:'系统提示',
  						zIndex: getzIndex(),
  						icon:'tips.gif',
  						content: 'msg'
  					}); */
  					requestall(url);
  			}	
  			
  			function data(){
  				$('.ui_content').html('haha');
  			}

  			 //请求
			 function requestall(url){
				 $.ajax({
						url : url,
						type : 'get',
						cache : false,
						success : function(data) {
							var d = $.parseJSON(data);
							var msg = d.msg;
							if (d.success) {
								sucSize += data.obj;
			  					tip('已成功'+sucSize+'条');
			  					if(data.msg != '上传完毕'){
			  						request(url);
			  					}else{
			  						tip(msg);
			  					}
							}else{
								tip(msg);
							}
						}
					});
			 }
  			 
  			 function deleteOrder(title, url, id, width, height, isRestful){
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
					url += '/' + rowsData[0].orderId;
				} else {
					url += '&orderId=' + rowsData[0].orderId;
				}
  				layer.open({
					title:"系统提示",
					content:"确认删除订单？",
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
  			 
  			 function doMyGo(url){
  				request(url,function(){
  					
  				});
  			 }
  			 
			//请求
			 function request(url,fn){
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
		</script>
 </div>