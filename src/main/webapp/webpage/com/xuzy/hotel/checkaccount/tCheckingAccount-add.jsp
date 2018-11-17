<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>对账单添加</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcCheckingAccount.do?doAdd" >
<%-- 					<input id="id" name="id" type="hidden" value="${tSCompanyPage.id }"/> --%>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">	
							对账明细主题:
						</label>
					</td>
					<td class="value">
					     	<input id=topic name="topic" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">对账明细主题</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							积分账户:
						</label>
					</td>
						<td class="value">
							<t:dictSelect field="accountType" type="select" typeGroupCode="atType" hasLabel="false" title="积分账户"></t:dictSelect> 
							<span class="Validform_checktip"></span>
						
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							明细时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="startTime" name="startTime" type="text" style="width: 150px" class="Wdate"  onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
					     	  ~ 
					     	 <input id="endTime" name="endTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"/> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">明细时间</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
