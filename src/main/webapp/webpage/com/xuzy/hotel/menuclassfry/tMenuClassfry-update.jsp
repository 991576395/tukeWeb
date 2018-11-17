<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>菜单分类表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tMenuClassfryController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tMenuClassfryPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								菜类名称:
							</label>
						</td>
						<td class="value">
						    <input id="claafryName" name="claafryName" type="text" style="width: 150px" class="inputxt"  ignore="checked" datatype="*" value='${tMenuClassfryPage.claafryName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">菜类名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								描述:
							</label>
						</td>
						<td class="value">
						    <input id="decription" name="decription" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tMenuClassfryPage.decription}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/xuzy/hotel/menuclassfry/tMenuClassfry.js"></script>		
