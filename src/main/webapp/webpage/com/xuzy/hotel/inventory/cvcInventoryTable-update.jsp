<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商品库存表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcInventoryTableController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${cvcInventoryTablePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品编号:
							</label>
						</td>
						<td class="value">
						    <input id="goodNumber" name="goodNumber" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${cvcInventoryTablePage.goodNumber}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品总量:
							</label>
						</td>
						<td class="value">
						    <input id="goodTotleSize" name="goodTotleSize" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${cvcInventoryTablePage.goodTotleSize}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品总量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								商品剩余数量:
							</label>
						</td>
						<td class="value">
						    <input id="goodSize" name="goodSize" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${cvcInventoryTablePage.goodSize}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品剩余数量</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/inventory/cvcInventoryTable.js"></script>		
