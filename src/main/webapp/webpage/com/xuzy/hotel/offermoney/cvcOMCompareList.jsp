<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="cvcOfferMoneyList" checkbox="false" pagination="true" fitColumns="false" collapsible="false" title="报价表" actionUrl="cvcOfferMoneyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公司名称"  field="companyName"  queryMode="single" hidden="true"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="商品名称"  field="goodName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="剔税价对比结果"  field="goodName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="含税价对比结果"  field="goodName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="期货对比结果"  field="goodName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
	</script>