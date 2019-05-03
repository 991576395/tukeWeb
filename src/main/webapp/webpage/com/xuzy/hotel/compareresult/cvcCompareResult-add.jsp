<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>对比结果表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="cvcCompareResultController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${cvcCompareResultPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							公司名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="companyName" name="companyName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">公司名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							商品名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="goodName" name="goodName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">商品名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							剔税价对比结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="tishuijiadbjg" name="tishuijiadbjg" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">剔税价对比结果</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							含税价对比结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="hanshuijiadbjg" name="hanshuijiadbjg" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">含税价对比结果</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							货期对比结果:
						</label>
					</td>
					<td class="value">
					     	 <input id="huoqidbjg" name="huoqidbjg" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货期对比结果</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/compareresult/cvcCompareResult.js"></script>		
