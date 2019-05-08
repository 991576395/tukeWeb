<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>报价表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  	 function refreshList(data){
//   		parent.reloadTable();
//   		parent.cvcOfferMoneyListsearch();
  	 }
  
  	
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" refresh="true"   dialog="true" usePlugin="password" layout="table" action="cvcOfferMoneyController.do?upOrDownCalculate" >
					<input id="ids" name="ids" type="hidden" value="${ids}"/>
					<input id="name" name="name" type="hidden" value="${name}"/>
					<input id="goodName" name="goodName" type="hidden" value="${goodName}"/>
					<input id="type" name="type" type="hidden" value="${type}"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							${name}百分比:
						</label>
					</td>
					<td class="value">
					     	 <input id="number" name="number" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							 &nbsp &nbsp %<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">${name}百分比</label>
						</td>
				</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/offermoney/cvcOfferMoney.js"></script>		
