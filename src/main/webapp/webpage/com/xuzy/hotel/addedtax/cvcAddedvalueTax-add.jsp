<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>增值税配置表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcAddedvalueTaxController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${cvcAddedvalueTaxPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							税种名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="taxName" name="taxName" type="text" style="width: 150px" class="inputxt"    ignore="ignore" />
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							增值税值:
						</label>
					</td>
					<td class="value">
					     	 <input id="addedvalueTax" name="addedvalueTax" type="text" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">增值税值</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/addedtax/cvcAddedvalueTax.js"></script>		
