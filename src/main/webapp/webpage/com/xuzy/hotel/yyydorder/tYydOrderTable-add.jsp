<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>优衣朵订单表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tYydOrderTableController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tYydOrderTablePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							客户:
						</label>
					</td>
					<td class="value">
					     	 <input id="client" name="client" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							订单量:
						</label>
					</td>
					<td class="value">
					     	 <input id="ordersize" name="ordersize" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">订单量</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							总金额:
						</label>
					</td>
					<td class="value">
					     	 <input id="totlemoney" name="totlemoney" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">总金额</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							被准:
						</label>
					</td>
					<td class="value">
					     	 <input id="content" name="content" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">被准</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/yyydorder/tYydOrderTable.js"></script>		
