<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>消息报表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcMessageTableController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${cvcMessageTablePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							消息内容:
						</label>
					</td>
					<td class="value">
					     	 <input id="messageContent" name="messageContent" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">消息内容</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							是否已读:
						</label>
					</td>
					<td class="value">
					     	 <input id="ifRead" name="ifRead" type="text" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否已读</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							消息类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="type" name="type" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">消息类型</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/message/cvcMessageTable.js"></script>		
