<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>标签集合</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid  pagination="false"  name="tagList" title="标签列表"  actionUrl="tTableTagController.do?datagrid" idField="id" checkbox="true" showRefresh="false"  fit="true"  queryMode="group" onLoadSuccess="initCheck">
	 <t:dgCol title="主键"   field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
	 <t:dgCol title="标签名"  field="tagName"  queryMode="single"  width="120"></t:dgCol>
</t:datagrid>
</body>
</html>
<script type="text/javascript">
function initCheck(data){
	var ids = "${ids}";
	var idArr = ids.split(",");
	for(var i=0;i<idArr.length;i++){
		if(idArr[i]!=""){
			$("#tagList").datagrid("selectRecord",idArr[i]);
		}
	}
}
</script>