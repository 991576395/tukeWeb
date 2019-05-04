<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="cvcCompareResultList" checkbox="false" pagination="false" fitColumns="true" title="对比结果表" actionUrl="cvcCompareResultController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  queryMode="single"  hidden="true"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="公司名称"  field="companyName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商品名称"  field="goodName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="剔税价对比结果"  field="tishuijiadbjg" formatterjs="formatAgeFun"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="含税价对比结果"  field="hanshuijiadbjg" formatterjs="formatAgeFun"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货期对比结果"  field="huoqidbjg" formatterjs="formatAgeFun"  queryMode="single"  width="120"></t:dgCol>
<%--    <t:dgCol title="操作" field="opt" width="100"></t:dgCol> --%>
<%--    <t:dgOpenOpt title="利润上调" width="700" height="600" url="cvcOfferMoneyController.do?goUpdateValue&name=上调&goodName={goodName}" urlclass="ace_button"  urlfont="fa-add-o"/> --%>
<%--    <t:dgOpenOpt title="利润下调" width="700" height="600" url="cvcOfferMoneyController.do?goUpdateValue&name=下调&goodName={goodName}" urlclass="ace_button"  urlfont="fa-add-o"/> --%>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="cvcCompareResultController.do?goAdd" funname="add"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="编辑" icon="icon-edit" url="cvcCompareResultController.do?goUpdate" funname="update"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="批量删除"  icon="icon-remove" url="cvcCompareResultController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="查看" icon="icon-search" url="cvcCompareResultController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar> --%>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>

 <t:dgToolBar title="利润上调" icon="icon-add" url="cvcOfferMoneyController.do?goUpdateValue&name=上调&type=1" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="利润下调" icon="icon-add" url="cvcOfferMoneyController.do?goUpdateValue&name=下调&type=1" funname="toUpdate"></t:dgToolBar>
   
   <t:dgToolBar title="剔税价上调" icon="icon-add" url="cvcOfferMoneyController.do?goUpdateValue&name=上调&type=2" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="剔税价下调" icon="icon-add" url="cvcOfferMoneyController.do?goUpdateValue&name=下调&type=2" funname="toUpdate"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/xuzy/hotel/compareresult/cvcCompareResultList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
//单元格的格式化函数  value：字段的值 row：行的记录数据 index：行的索引
 function formatAgeFun(value,row,index){
	var number = parseFloat(value);
 	if(number > 0){
 		return "<font color='green'>"+value+"%</font>";
 	}else{
 		return "<font color='red'>"+value+"%</font>";
 	}
 }		
 
 function toUpdate(title, url, id, width, height, isRestful) {
		var rowsData = $('#' + id).datagrid('getSelections');
		if (!rowsData || rowsData.length == 0) {
			tip('请选择操作商品');
			return;
		}
		if (rowsData.length > 1) {
			tip('请选择一条商品再操作');
			return;
		}
		if (isRestful != 'undefined' && isRestful) {
			url += '/' + rowsData[0].goodName;
		} else {
			url += '&goodName=' + rowsData[0].goodName;
		}
		createwindow(title,url,width, height);
	}

	function createMywindow(title, addurl, width, height) {
		width = width ? width : 700;
		height = height ? height : 400;
		if (width == "100%" || height == "100%") {
			width = window.top.document.body.offsetWidth;
			height = window.top.document.body.offsetHeight - 100;
		}
		$.dialog({
			content : 'url:' + addurl,
			lock : true,
			zIndex : getzIndex(),
			width : width,
			height : height,
			title : title,
			opacity : 0.3,
			cache : false,
			cancelVal : '关闭',
			cancel : true
		/*为true等价于function(){}*/
		});
	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'cvcCompareResultController.do?upload', "cvcCompareResultList");
}

//导出
function ExportXls() {
	JeecgExcelExport("cvcCompareResultController.do?exportXls","cvcCompareResultList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("cvcCompareResultController.do?exportXlsByT","cvcCompareResultList");
}

 </script>