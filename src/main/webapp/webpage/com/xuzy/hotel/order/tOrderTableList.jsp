<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="菜名维护" actionUrl="cvcOrderInfo.do?datagrid"  queryMode="group" pageSize="15" idField="id" fit="true">
   <t:dgCol title="订单批次" field="batchNo"  queryMode="single" query="true" defaultVal="${batchNo}"  width="80"></t:dgCol>
   <t:dgCol title="礼品编号" field="goodsSn"  query="true"  width="80"></t:dgCol>
   <t:dgCol title="订单号" field="id" queryMode="single"  query="true"   width="80"></t:dgCol>
   <t:dgCol title="收货人" field="consignee"   width="70"></t:dgCol>
   <t:dgCol title="订单状态" field="orderStatus" queryMode="single" dictionary="OStatus" defaultVal="${orderStatus}"  query="true"  width="100"></t:dgCol>
   <t:dgCol title="伊利订单状态" field="ylOrderStatus" queryMode="single" dictionary="OStatus"  query="true"  width="100"></t:dgCol>
   <t:dgCol title="快递公司" field="shippingId" queryMode="single" dictionary="cvc_shipping where enabled = '1',shipping_id,shipping_name" query="true"  width="80"></t:dgCol>
   <t:dgCol title="快递单号" field="invoiceNo" queryMode="single"  query="true"  width="120"></t:dgCol>
   <t:dgCol title="是否异常" field="exceptionStatus" hidden="true" queryMode="single" dictionary="isExp" defaultVal="${exceptionStatus}"  query="true"  width="70"></t:dgCol>
   <t:dgCol title="是否处理异常" field="isShow" hidden="true" queryMode="single" dictionary="EpIsDo" defaultVal="${isShow}"  query="true"  width="70"></t:dgCol>
   <t:dgCol title="是否异常" field="exceptionStatusString"  width="90"></t:dgCol>
   <t:dgCol title="下单时间" field="addTime" formatter="yyyy-MM-dd hh:mm:ss"  queryMode="group"  query="true"  width="160"></t:dgCol>
   <t:dgCol title="抓单时间" field="getTime" formatter="yyyy-MM-dd hh:mm:ss"  width="160"></t:dgCol>
   <t:dgCol title="结算标识" field="isBalance"  queryMode="single" dictionary="is_balance"   query="true"  width="70"></t:dgCol>
   <t:dgCol title="积分账户" field="userName" queryMode="single" dictionary="atType"   query="true"  width="60"></t:dgCol>
   <t:dgCol title="订单来源" field="orderSourceName"    query="false"  width="60"></t:dgCol>
	
<%--    <c:if test="${orderStatus == 7}"> --%>
   		<t:dgCol title="退货原因" field="returnReason" queryMode="single" dictionary="rtReason"  query="true"  width="120"></t:dgCol>
<%--    </c:if> --%>

   <t:dgToolBar title="查看详情" icon="icon-search" url="cvcOrderInfo.do?toDetail" width="1000" height="600" funname="goLook"></t:dgToolBar>
   
   <t:dgToolBar title="导出EXCEL" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   
   <t:dgToolBar id="sureOrder" title="确认订单" icon="icon-edit" url="cvcGetOrderStatistics.do?setOrderRead" funname="sureOrder"></t:dgToolBar>
   <t:dgToolBar id="allocateOrder" title="仓库配货" icon="icon-edit" url="cvcGetOrderStatistics.do?allocateOrder" funname="allocateOrder"></t:dgToolBar>
   
   <t:dgToolBar title="推送至离港" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=offharbour"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="推送至配送中" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=send"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="推送至签收" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=signin"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="推送至签收失败" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=signFailure"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="取消订单" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=quitOrder"  funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="同步物流" icon="icon-edit" url="cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=getOrderWuliu"  funname="toUpdate"></t:dgToolBar> 
   <t:dgToolBar title="批量同步物流" icon="icon-edit" funname="batchTogetherWuliu"></t:dgToolBar>
 </t:datagrid>
  </div>
  
  <script type="text/javascript">
  
	//仓库配货
	  function allocateOrder(title, url, id, width, height, isRestful) {
			layer.open({
				title:"系统提示",
				content:"确认操作？",
				icon:7,
				shade: 0.3,
				yes:function(index){
					request(url,function (d){
						tOrderListsearch();
					});
				},
				btn:['确定','取消'],
				btn2:function(index){
					layer.close(index);
				}
			}); 
		}
  
  		//  确认订单
	  function sureOrder(title, url, id, width, height, isRestful) {
			layer.open({
				title:"系统提示",
				content:"确认操作？",
				icon:7,
				shade: 0.3,
				yes:function(index){
					request(url,function (d){
						tOrderListsearch();
					});
				},
				btn:['确定','取消'],
				btn2:function(index){
					layer.close(index);
				}
			}); 
		}
  
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
			var getTimeStart =  $("input[name='getTimeStart']").val();
			var getTimeEnd =  $("input[name='getTimeEnd']").val();
			var goodsSn =  $("input[name='goodsSn']").val();
			
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
			if (getTimeStart != 'undefined' && getTimeStart.length > 0) {
				url+="&getTimeStart="+getTimeStart;
			}
			if (getTimeEnd != 'undefined' && getTimeEnd.length > 0) {
				url+="&getTimeEnd="+getTimeEnd;
			}
			if (goodsSn != 'undefined' && goodsSn.length > 0) {
				url+="&goodsSn="+goodsSn;
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
							tOrderListsearch();
						});
					},
					btn:['确定','取消'],
					btn2:function(index){
						layer.close(index);
					}
				}); 
			}
  				
		  function getOrderWuliu(id) {
				layer.open({
					title:"系统提示",
					content:"确认操作？",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=getOrderWuliu&id='+id,function (d){
							tOrderListsearch();
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
				
			
			$(document).ready(function(){  
				$("#sureOrder").hide();
				$("#allocateOrder").hide();
				
// 				var orderStatus = '${orderStatus}';
// 				if(nodeNo == 0){
// 					$("#sureOrder").show();
// 					$("#allocateOrder").hide();
// 				}else if(nodeNo == 1){
// 					$("#sureOrder").hide();
// 					$("#allocateOrder").show();
// 				}
			     // 添加事件
				$("[name='orderStatus']").change(function(e) {
					var nodeNo = e.target.value; // 获取选中下拉框的值
// 					alert(nodeNo);
					// 业务代码         
					if(nodeNo == 0){
						$("#sureOrder").show();
						$("#allocateOrder").hide();
					}else if(nodeNo == 1){
						$("#sureOrder").hide();
						$("#allocateOrder").show();
					}
				});
			     
			    //添加抓单日期区间
				$("#tOrderListForm  span:first").append("<span style=\"display:-moz-inline-box;display:inline-block;margin-bottom:2px;text-align:justify;\"><span style=\"vertical-align:middle;display:-moz-inline-box;display:inline-block;width: 90px;text-align:right;text-overflow:ellipsis;-o-text-overflow:ellipsis; overflow: hidden;white-space:nowrap; \" title=\"抓单日期\">抓单日期：</span> <input onkeypress=\"EnterPress(event)\" onkeydown=\"EnterPress()\" type=\"text\" name=\"getTimeStart\" style=\"width: 55px\" class=\"inuptxt\">- <input onkeypress=\"EnterPress(event)\" onkeydown=\"EnterPress()\" type=\"text\" name=\"getTimeEnd\" style=\"width: 55px\" class=\"inuptxt\"></span>");
			     
			});
			
			
			  function batchTogetherWuliu() {
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
				var getTimeStart =  $("input[name='getTimeStart']").val();
				var getTimeEnd =  $("input[name='getTimeEnd']").val();
				var goodsSn =  $("input[name='goodsSn']").val();
				
				var url = "cvcOrderInfo.do?batchTogetherWuliu";
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
				if (getTimeStart != 'undefined' && getTimeStart.length > 0) {
					url+="&getTimeStart="+getTimeStart;
				}
				if (getTimeEnd != 'undefined' && getTimeEnd.length > 0) {
					url+="&getTimeEnd="+getTimeEnd;
				}
				if (goodsSn != 'undefined' && goodsSn.length > 0) {
					url+="&goodsSn="+goodsSn;
				}
				
				request(url,function (d){
					tOrderListsearch();
				});
			  }	 
			
			
		</script>
 </div>