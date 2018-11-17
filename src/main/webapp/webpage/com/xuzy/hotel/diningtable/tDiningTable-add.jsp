<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>餐桌表</title>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
  //编写自定义JS代码
  </script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="tDiningTableController.do?doAdd">
		<input id="id" name="id" type="hidden" value="${tDiningTablePage.id }" />
		<table style="width: 600px;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 餐桌名:
				</label></td>
				<td class="value"><input id="tablename" name="tablename"
					type="text" style="width: 150px" class="inputxt" ignore="ignore" />
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">餐桌名</label></td>
			</tr>

			<!--  餐桌标签 -->
			<tr>
				<td align="right"><label class="Validform_label"> <t:mutiLang
							langKey="餐桌标签" />:
				</label></td>
				<td class="value" nowrap><input id="tableTagId"
					name="tableTagId" type="hidden" value="${id}" /> <input
					name="tagName" id="tagName" class="inputxt" value="${tagName}"
					readonly="readonly" datatype="*" /> <t:choose
						hiddenName="tableTagId" hiddenid="id" textname="tagName"
						url="tTableTagController.do?choiceTableTag" name="tagList"
						icon="icon-search" title="餐桌标签" isclear="true" isInit="true"></t:choose>
					<span class="Validform_checktip"><t:mutiLang
							langKey="餐桌标签可多选" /></span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 餐桌介绍:
				</label></td>
				<td class="value"><textarea style="width: 500px;"
						class="inputxt" rows="6" id="tabletintroduce"
						name="tabletintroduce" ignore="ignore"></textarea> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">餐桌介绍</label></td>
			</tr>

		</table>
	</t:formvalid>
</body>
<script src="webpage/com/xuzy/hotel/diningtable/tDiningTable.js"></script>