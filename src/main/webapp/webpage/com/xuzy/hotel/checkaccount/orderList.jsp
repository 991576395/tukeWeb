<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  	<t:datagrid name="tCheckOrderList" title="对账订单" actionUrl="cvcCheckingAccountOrder.do?datagrid&checkingAccountId=${checkingAccountId}"  queryMode="group" pageSize="15" idField="id" fit="true">
   	<t:dgCol title="编号" field="id"   width="80"></t:dgCol>
   	<t:dgCol title="对账表头ID" field="checkingAccountId" defaultVal="${checkingAccountId}"  width="80"></t:dgCol>
   	<t:dgCol title="订单号" field="orderId"  query="true" queryMode="single"  width="80"></t:dgCol>
   	<t:dgCol title="礼品编号" field="goodsSn"  width="100"></t:dgCol>
  	<t:dgCol title="快递公司" field="shippingName"  width="120"></t:dgCol>
   	<t:dgCol title="快递单号" field="invoiceNo" query="true" queryMode="single"  width="100"></t:dgCol>
   	<t:dgCol title="状态" field="statueName"  width="120"></t:dgCol>
   	<t:dgCol title="上传时间" field="addCheckingAccountTimeFormat" width="120"></t:dgCol>
   	<t:dgCol title="上传状态" field="isAddCheckingAccount" hidden="true" query="true" queryMode="single" dictionary="upstatus"  width="120"></t:dgCol>
   	
   	
   	<t:dgToolBar title="上传对账明细" icon="icon-putout" url="cvcCheckingAccountOrder.do?addCheckingAccount&checkingAccountId=${checkingAccountId}"  funname="addCheckingAccount"></t:dgToolBar>
   	<t:dgToolBar title="重新生成对账明细" icon="icon-edit"   onclick="doMyGo('cvcCheckingAccount.do?updateCheckingAccountOrder&checkingAccountId=${checkingAccountId}')"></t:dgToolBar>
 	<t:dgToolBar title="封账" icon="icon-add" onclick="doMyGo('cvcCheckingAccount.do?makeBalance&checkingAccountId=${checkingAccountId}')"></t:dgToolBar>
 	<t:dgToolBar title="编辑" icon="icon-edit" url="cvcCheckingAccountOrder.do?goUpdate" funname="toUpdate"></t:dgToolBar>
 	<t:dgToolBar title="导出EXCEL" icon="icon-put" onclick="exportEXCEL('cvcCheckingAccountOrder.do?exportXls&checkingAccountId=${checkingAccountId}')"></t:dgToolBar>
 	<t:dgToolBar title="删除" icon="icon-remove" url="cvcCheckingAccountOrder.do?doDelete" funname="deleteOrder" ></t:dgToolBar>
 
  </t:datagrid>
  </div>
  
  
  <script type="text/javascript">
  
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
		url += '&id=' + ${checkingAccountId};
		url += '&orderId=' + rowsData[0].orderId;
		
		createwindow(title,url,width,height);
	}
  
  
	  	function exportEXCEL(url) {
			 window.location.href=url;
		}
  
			function addCheckingAccount(title, url) {
				layer.open({
					title : "系统提示",
					content : "确认上传对账明细？",
					icon : 7,
					shade : 0.3,
					yes : function(index) {
						requestall(url,1,0,0,0);
					},
					btn : [ '确定', '取消' ],
					btn2 : function(index) {
						layer.close(index);
					}
				});
			}
			
			function responseCall(url,d){
				if (d.obj.totelSize == (d.obj.sucSize + d.obj.faildSize)) {
					tCheckOrderListsearch();
					tip("上传完成！");
				} else{
					requestall(url,0,d.obj.totelSize,d.obj.sucSize,d.obj.faildSize);
				}
			}
			
			function data() {
				$('.ui_content').html('haha');
			}

			//请求
			function requestall(url,first,totelSize,sucSize,faildSize) {
				$.ajax({
					url : url+"&first="+first+"&totelSize="+totelSize+"&sucSize="+
						sucSize+"&faildSize="+faildSize,
					type : 'get',
					cache : false,
					success : function(data) {
						var d = $.parseJSON(data);
						var msg = d.msg;
						if (d.success) {
							responseCall(url,d);
						} else {
							tip(msg);
						}
					}
				});
			}

			function deleteOrder(title, url, id, width, height, isRestful) {
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
				layer.open({
					title : "系统提示",
					content : "确认删除订单？",
					icon : 7,
					shade : 0.3,
					yes : function(index) {
						request(url, function(d) {
							reloadTable();
						});
					},
					btn : [ '确定', '取消' ],
					btn2 : function(index) {
						layer.close(index);
					}
				});
			}

			function doMyGo(url) {
				request(url, function() {

				});
			}

			//请求
			function request(url, fn) {
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