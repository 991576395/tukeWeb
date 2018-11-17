<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tSClientTableList" checkbox="false" pagination="true" fitColumns="true" title="客户表" actionUrl="tSClientTableController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户生日"  field="birthday"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="地址"  field="address"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系电话或手机"  field="phone"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司名"  field="commpany"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="content"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="续单周期开始时间"  field="startorderdate"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="续单周期"  field="orderperiod"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="周期单位"  field="ordertype"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tSClientTableController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tSClientTableController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tSClientTableController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tSClientTableController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tSClientTableController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/xuzy/hotel/client/tSClientTableList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tSClientTableController.do?upload', "tSClientTableList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tSClientTableController.do?exportXls","tSClientTableList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tSClientTableController.do?exportXlsByT","tSClientTableList");
}

 </script>