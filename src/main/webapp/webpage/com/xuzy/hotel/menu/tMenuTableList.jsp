<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tMenuTableList" title="菜名维护" actionUrl="tMenuTableController.do?datagrid" treegrid="true" idField="id" fit="true">
   <t:dgCol title="编号" field="id" treefield="id" hidden="true"></t:dgCol>
   <t:dgCol title="所属部门" field="sys_org_code" hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="所属公司" field="companyid" hidden="true"   width="120"></t:dgCol>
   <t:dgCol title="流程状态" field="bpm_status"  hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="所属菜类id" field="classfryid"  hidden="true" width="120"></t:dgCol>
   <t:dgCol title="菜名" field="dishName"   width="120"></t:dgCol>
   <t:dgCol title="描述" field="decription"   width="120"></t:dgCol>
   <t:dgCol title="库存量" field="storageNumber"   width="120"></t:dgCol>
<%--    <t:dgCol title="文件表id" field="fileid"   width="120"></t:dgCol> --%>
    <t:dgCol title="图片"  field="fileid.realpath" align="center"  image="true"  imageSize="80,60"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tMenuTableController.do?del&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tMenuTableController.do?addorupdate" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tMenuTableController.do?addorupdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tMenuTableController.do?addorupdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>