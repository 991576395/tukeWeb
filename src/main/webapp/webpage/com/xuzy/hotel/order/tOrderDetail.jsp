<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>订单详情</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="plug-in/ace/css/bootstrap.css" />
<script type="text/javascript">
			//去发货
			function toShip(order_id){
// 				alert(order_id);
				window.location.href= 'cvcOrderInfo.do?toShip&orderId='+order_id;  
			}
		
		function updateStatue(url,title,order_id){
			layer.open({
				title:"系统提示",
				content:title,
				icon:7,
				shade: 0.3,
				yes:function(index){
					request(url+'&id='+order_id,function (d){
						window.location.href= 'cvcOrderInfo.do?toDetail&id='+order_id;  
					});
				},
				btn:['确定','取消'],
				btn2:function(index){
					layer.close(index);
				}
			});
		}
		
		
		function showException(){
			 $("#return_tips").show();
			  $("#return_reason").show();
			  $("#return_sub").show();
		}
			
		 //更新快递单号
		  function update_nu(order_id){
			  layer.open({
					title:"系统提示",
					content:"确认修改？",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request('cvcOrderInfo.do?updateNu&orderId='+order_id+'&invoiceNo='+$("#invoice_no").val()+'&shippingName='+$("#shipping_name").val(),function (d){
						});
					},
					btn:['确定','取消'],
					btn2:function(index){
						layer.close(index);
					}
				});
		  }
		
		
		 //更新签收时间
		  function update_signdate(order_id){
			  layer.open({
					title:"系统提示",
					content:"确认修改？",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request('cvcOrderInfo.do?updateSigndate&orderId='+order_id+'&signdate='+$("#signdate_id").val(),function (d){
							$("#signinDate").html('签收时间：'+$("#signdate_id").val());
							$("#signdate_id").val('');
						});
					},
					btn:['确定','取消'],
					btn2:function(index){
						layer.close(index);
					}
				});
		  }
		 
		 //处理异常订单
		 function epChuLi(order_id){
			 layer.open({
					title:"系统提示",
					content:"是否处理异常订单",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request('cvcOrderInfo.do?epUpdate&id='+order_id,function (d){
							window.location.href= 'cvcOrderInfo.do?toDetail&id='+order_id;  
						});
					},
					btn:['确定','取消'],
					btn2:function(index){
						layer.close(index);
					}
				});
		 }
		 
		 
		function returnGood(order_id){
			layer.open({
				title:"系统提示",
				content:"是否申请退货",
				icon:7,
				shade: 0.3,
				yes:function(index){
					request('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=return&id='+order_id+'&returnReason='+$('#returnReason').val(),function (d){
						window.location.href= 'cvcOrderInfo.do?toDetail&id='+order_id;  
					});
				},
				btn:['确定','取消'],
				btn2:function(index){
					layer.close(index);
				}
			});
		}
		 
		 //申请返货
		 function returnWareHouse(order_id){
			 layer.open({
					title:"系统提示",
					content:"是否申请返货",
					icon:7,
					shade: 0.3,
					yes:function(index){
						request('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=returnWareHouse&id='+order_id+'&backingReason='+$('#backingReason').val(),function (d){
							window.location.href= 'cvcOrderInfo.do?toDetail&id='+order_id;  
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
</head>
<body>
	<div class="list-div" style="border-bottom: none; margin-top: 10px">
		<table width="100%" cellpadding="3" cellspacing="0"
			class="form-horizontal table table-bordered">
			<tr height="50px;">
				<td colspan="3" align="left"
					style="font-size: 25px; text-indent: 1em">订单号：${cvcOrderInfoEntity.orderSn}</td>
				<td colspan="3" align="center" style="padding-top: 15px">
					下单时间：${cvcOrderInfoEntity.addTime}&nbsp;&nbsp; <!-- <input type="button" value="锁定"/>
      <input type="button" value="解锁"/> -->
				</td>
			</tr>
			<tr>
				<td colspan="6" style="text-indent: 2.5em;"><strong>收货人信息</strong>
				</th>
			</tr>
			<tr>
				<td><div align="right">
						<strong>收货人：</strong>
					</div></td>
				<td>${cvcOrderInfoEntity.consignee}</td>
				<td><div align="right">
						<strong>电子邮件：</strong>
					</div></td>
				<td colspan="3">${cvcOrderInfoEntity.email}</td>
			</tr>
			<tr>
				<td><div align="right">
						<strong>地址：</strong>
					</div></td>
				<td>${cvcOrderInfoEntity.address}</td>
				<td><div align="right">
						<strong>邮编：</strong>
					</div></td>
				<td colspan="3">${cvcOrderInfoEntity.zipcode}</td>
			</tr>
			<tr>
				<td><div align="right">
						<strong>电话：</strong>
					</div></td>
				<td>${cvcOrderInfoEntity.tel}</td>
				<td><div align="right">
						<strong>手机：</strong>
					</div></td>
				<td colspan="3">${cvcOrderInfoEntity.mobile}</td>
			</tr>
			<tr>
				<td><div align="right">
						<strong>订单备注</strong>
					</div></td>
				<td>${cvcOrderInfoEntity.remark}</td>
			</tr>
		</table>
	</div>


	<div class="list-div" style="border-top: none; border-bottom: none;">
		<table width="100%" cellpadding="3" cellspacing="0"
			class="table table-bordered">
			<tr>
				<td style="text-indent: 2.5em" colspan="13"><strong>商品情况</strong></td>
			</tr>
			<tr>
				<td scope="col" style="text-indent: 2.5em"><div align="left">商品名称
						[ 品牌 ]</div></td>
				<td scope="col"><div align="center">商品编号</div></td>
				<td scope="col"><div align="center">数量</div></td>
			</tr>

			<c:if test="${fn:length(goods_list) > 0}">
				<c:forEach var="goods" items="${goods_list}">
					<tr>
						<td style="text-indent: 2.5em">
							<div id="suit_${goods.goodsId}">${goods.goodsSn}</div>
						</td>
						<td align="center">${goods.goodsSn}</td>
						<td align="center">${goods.goodsNumber}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<div class="list-div" style="margin-bottom: 10px; border-top: none;">
		<table cellpadding="3" cellspacing="0" class="table table-bordered">
			<tr>
				<td style="text-indent: 2.5em" colspan="6" align="left"><strong>当前可执行操作：</strong>
					<!-- 发货 --> 
					<c:if test="${cvcOrderInfoEntity.orderStatus eq 2}">
						<!-- 						<input name="ship" type="submit" value="去发货" class="button" /> -->

						<button type="button" name="ship" class="btn btn-primary btn-sm"
							style="margin-left: 20px;" onclick="toShip('${cvcOrderInfoEntity.id}')">去发货</button>

					</c:if> 
					<!-- 退货 --> 
					<c:if test="${cvcOrderInfoEntity.orderStatus eq 5}">
						<!--input name="" type="submit" value="{$lang.op_return}" class="button" /-->
					</c:if> <input name="order_id" type="hidden"
					value="${smarty.request.order_id}">
					
					
					<!-- 处理异常 -->
					<c:if test="${cvcOrderInfoEntity.exceptionStatus > 0}">
						<button type="button" name="epChuLi" class="btn btn-primary btn-sm"
								style="margin-left: 20px;" onclick="epChuLi('${cvcOrderInfoEntity.id}')">处理异常</button>

					</c:if> 
					</td>
					<td style="text-indent: 2.5em" colspan="4" align="left">
					&nbsp;&nbsp;返货原因：
					<input type="text" id="backingReason" name="backingReason" style="width: 200px">
					<!-- 申请返仓 -->
					 &nbsp;&nbsp;
					<button type="button" name="returnWareHouse" class="btn btn-primary btn-sm"
						style="margin-left: 20px;"
						onclick="returnWareHouse('${cvcOrderInfoEntity.id}')">申请返仓</button>
					</td>
					
			</tr>
			<tr>
				<td style="text-indent: 2.5em" colspan="6" align="left">
						退货原因：
						<input type="text" id="returnReason" name="returnReason" style="width: 200px">
						<!-- 申请返仓 -->
						 &nbsp;&nbsp;
						<button type="button" name="return" class="btn btn-primary btn-sm"
							style="margin-left: 20px;"
							onclick="returnGood('${cvcOrderInfoEntity.id}')">申请退货</button>
					</td>
			</tr>
		</table>
	</div>

	<div class="list-div"
		style="margin-bottom: 10px; border-top: none; border-bottom: none;">

		<table width="100%" cellpadding="3" cellspacing="0"
			class="table table-bordered">
			<tr>
				<td style="text-indent: 2.5em" colspan="10"><strong>发货商品情况</strong>
				</td>
			</tr>

			<c:if test="${fn:length(delivery_goods) > 0}">
				<c:forEach var="goods" items="${delivery_goods}">
					<tr>
						<td style="text-indent: 2.5em" colspan="10"><c:if
								test="${fn:length(goods.preArrivalDate) > 0}">
								<strong id="signinDate">签收时间：${goods.signinDate}</strong>&nbsp;&nbsp;&nbsp;&nbsp;
								<c:choose>
									<c:when test="${cvcOrderInfoEntity.orderStatus == 5}">
										<strong> <input id="signdate_id" name="signdate"
											type="text" style="width: 200px" class="Wdate"
											onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />

											<button type="button" class="btn btn-primary btn-sm"
												style="margin-left: 20px;"
												onclick="update_signdate('${goods.orderId}')">修改</button>
										</strong>
									</c:when>
									<c:otherwise>
										<strong>快递公司： <%-- 											<input type="text" name="shippingName" id="shipping_name" value="${goods.shippingName}"> --%>
											<select name="shippingName" id="shipping_name">
												<option value="">-- 请选择 --</option>
												<c:if test="${fn:length(shippingEntitys) > 0}">
													<c:forEach var="shippingEntity" items="${shippingEntitys}">
														<option value="${shippingEntity.shippingName}"
															<c:if test="${shippingEntity.shippingName eq goods.shippingName}">
															selected="selected"
														</c:if>>${shippingEntity.shippingName}</option>
													</c:forEach>
												</c:if>
										</select> &nbsp;&nbsp;快递单号： <input type="text" name="invoice_no"
											id="invoice_no" value="${goods.invoiceNo}">

											<button type="button" class="btn btn-primary btn-sm"
												style="margin-left: 20px;"
												onclick="update_nu('${goods.orderId}')">修改</button>

										</strong>
									</c:otherwise>
								</c:choose>
							</c:if></td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<c:if test="${is_show_shipping_info}">
		
	
	
		<div class="list-div"
			style="margin-bottom: 10px; border-top: none; border-bottom: none;">
			<table width="100%" cellpadding="3" cellspacing="0"
				class="table table-bordered">
				
				<c:if test="${fn:length(deliveryOrders) > 0}">
					<c:forEach var="deliveryOrder" items="${deliveryOrders}">
						<tr>
							<td style="text-indent: 2.5em" colspan="10"><strong>物流公司：${deliveryOrder.shippingName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发货时间：${deliveryOrder.addTimeString}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作人：${deliveryOrder.actionUser}</strong>
							</td>
						</tr>
						<tr>
							<td style="text-indent: 2.5em" colspan="10"><strong>快递单号：${deliveryOrder.invoiceNo}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预计到达时间：${deliveryOrder.preArrivalDate}</strong>
							</td>
						</tr>
						<tr/>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</c:if>

	<div class="list-div"
		style="margin-bottom: 10px; border-top: none; border-bottom: none; display: none;">
		<table width="100%" cellpadding="3" cellspacing="0"
			class="table table-bordered">
			<tr>
				<td style="text-indent: 2.5em" colspan="10"><strong>撤销商品情况</strong>
					<hr></td>
			</tr>
			<tr>
				<td scope="col"><div align="center">货号</div></td>
				<td scope="col"><div align="center">价格</div></td>
				<td scope="col"><div align="center">数量</div></td>
				<td scope="col"><div align="center">小计</div></td>
				<td scope="col"><div align="center">操作</div></td>
			</tr>
			<c:if test="${fn:length(revoke_goods) > 0}">
				<c:forEach var="r_goods" items="${revoke_goods}">
					<tr>
						<td style="text-indent: 2.5em">${r_goods.goodsName}</td>
						<td align="center">${r_goods.goodsSn}</td>
						<td align="center">${r_goods.goodsPrice}</td>
						<td align="center">${r_goods.number}</td>
						<td align="center">${r_goods.total}</td>
						<td align="center"><input type="button" value="加入购物车"
							onclick="javascript:openAjaxDiv('order.php?act=add_window&order_id={$r_goods.order_id}&system_sku={$r_goods.system_sku}&r_id={$r_goods.r_id}');" />
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>

	<div class="list-div" style="margin-bottom: 5px; border-top: none;">
		<table cellpadding="3" cellspacing="0" class="table table-bordered">
			<tr>
				<th>操作者：</th>
				<th>操作时间</th>
				<th>备注</th>
			</tr>
			<c:if test="${fn:length(action_list) > 0}">
				<c:forEach var="action" items="${action_list}">
					<tr>
						<td><div align="left">${action.actionUser}</div></td>
						<td><div align="left">${action.actionTime}</div></td>
						<td>${action.actionNote}</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${fn:length(deliveryInfoPojos) > 0}">
			<c:forEach var="deliveryInfoPojo" items="${deliveryInfoPojos}">
					
						<div class="list-div"
							style="margin-bottom: 10px; border-top: none; border-bottom: none;">
							<table width="100%" cellpadding="3" cellspacing="0"
								class="table table-bordered">
								<tr>
									<td style="text-indent: 2.5em" colspan="10"><strong>（单号:${deliveryInfoPojo.invoiceNo}）物流信息</strong>
										</td>
								</tr>
								<c:if test="${fn:length(deliveryInfoPojo.deliveryInfos) > 0}">
								<c:forEach var="data" items="${deliveryInfoPojo.deliveryInfos}">
									<tr>
										<td scope="col"><div align="center">${data.ftime}</div></td>
										<td scope="col"><div align="center">${data.context}</div></td>
									</tr>
								</c:forEach>
								</c:if>		
							</table>
						</div>
			</c:forEach>
		</c:if>
		
		<c:if test="${is_show_exception}">
			<input name="cancel" type="button" class="btn btn-primary btn-sm" value="确认已签收" class="button"
				onclick="updateStatue('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=signin','请确认签收？','${cvcOrderInfoEntity.id}')" />
			<c:if test="${exception_status == 2 || exception_status == 3}">
				<input name="cancel" type="button" class="btn btn-primary btn-sm" value="退货" class="button"
					onclick="showException()" />
			</c:if>
			<span style="display: none;" id="return_tips">退货原因：</span>
			<select name="return_reason" id="return_reason"
				style="display: none;">
				<option value="0">请选择</option>
				<option value="1">包裹损坏</option>
				<option value="2">地址不详</option>
				<option value="3">退积分</option>
			</select>
			<input name="cancel" type="button" class="btn btn-primary btn-sm" value="确定" 
				onclick="updateStatue('cvcOrderInfo.do?orderStatusUpdate&tkOrderStatus=return','请确认退货？','${cvcOrderInfoEntity.id}')" id="return_sub"
				style="display: none;" />
		</c:if>
</body>
</html>