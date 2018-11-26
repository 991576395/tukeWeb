<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tOrderList" title="菜名维护" actionUrl="cvcShippingBatchOrder.do?datagrid&batchNo=${batchNo}"  queryMode="group" pageSize="15" idField="id" fit="true">
   	<t:dgCol title="编号" field="id"    width="80"></t:dgCol>
   	<t:dgCol title="订单号" field="orderId" query="true" queryMode="single"   width="80"></t:dgCol>
   	<t:dgCol title="快递公司" field="shippingName"  ></t:dgCol>
   	<t:dgCol title="快递单号" field="invoiceNo" query="true" queryMode="single"    width="80"></t:dgCol>
   	<t:dgCol title="预计到达时间" field="preArrivalDate" ></t:dgCol>
   	<t:dgCol title="状态" field="status" dictionary="isupload" query="true" queryMode="single"  ></t:dgCol>
   	<t:dgCol title="是否属于本订单批次号"  field="isOrderBatchNoOkStr"  ></t:dgCol>
	<t:dgCol title="操作" field="opt" width="150"></t:dgCol>
	<t:dgFunOpt title="重发"   urlclass="ace_button" urlfont="fa-send"  funname="toShip(orderId)"/>
   	<t:dgFunOpt title="查看详情"   urlclass="ace_button" urlfont="fa-search"  funname="goLook(orderId)"/>
   	<t:dgToolBar title="发货" icon="icon-search" url="cvcShippingBatchOrder.do?ship&batchNo=${batchNo}"  funname="ship"></t:dgToolBar>
   </t:datagrid>
  </div>
  
  <script type="text/javascript">
  	 var totelSize = 0;
  	 var sucSize = 0;
  	 var faildSize = 0;
  
	  function ship(title, url, id, width, height, isRestful) {
			layer.open({
				title:"系统提示",
				content:"确认发货？",
				icon:7,
				shade: 0.3,
				yes:function(index){
					request(url+"&first=1",function (d){
						if(d.obj.totelSize > 0){
							totelSize = d.obj.totelSize;
						}
						sucSize += d.obj.sucSize;
						faildSize+= d.obj.faildSize;
						if(totelSize = (sucSize + faildSize)){
							tip("发货完成！");
						}else{
							request(url+"&first=0",this);
						}
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
						
						if (d.success) {
							fn.call(d);
						}else{
							tip(msg);
						}
					}
				});
		 } 
	  	
	  	
  	function toShip(orderId){
  		var url = 'cvcShippingBatchOrder.do?ship&batchNo=${batchNo}&orderId='+orderId;
  		layer.open({
			title:"系统提示",
			content:"确认发货？",
			icon:7,
			shade: 0.3,
			yes:function(index){
				request(url+"&first=1",function (d){
					tip("发货完成！");
				});
			},
			btn:['确定','取消'],
			btn2:function(index){
				layer.close(index);
			}
		}); 
  	}
  
   function goLook(id) {
		var url = 'cvcOrderInfo.do?toDetail&id=' + id;
		createMywindow("订单详情", url, 1200, 800);
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