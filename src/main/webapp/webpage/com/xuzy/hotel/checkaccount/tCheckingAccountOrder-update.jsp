<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>订单修改</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="cvcCheckingAccountOrder.do?doEdit">
		<input id="id" name="id" type="hidden" value="${checkingAccountOrderEntity.id}" />
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label">快递公司:
				</label></td>
				<td class="value"><input id="shippingName" name="shippingName"
					type="text" style="width: 150px" class="inputxt" ignore="ignore"
					value='${checkingAccountOrderEntity.shippingName}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">快递公司</label></td>
			</tr>
			
			<tr>
				<td align="right"><label class="Validform_label"> 快递单号:
				</label></td>
				<td class="value"><input id="invoiceNo" name="invoiceNo"
					type="text" style="width: 150px" class="inputxt" ignore="ignore"
					value='${checkingAccountOrderEntity.invoiceNo}' /> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">快递单号</label></td>
			</tr>

		</table>
	</t:formvalid>
</body>