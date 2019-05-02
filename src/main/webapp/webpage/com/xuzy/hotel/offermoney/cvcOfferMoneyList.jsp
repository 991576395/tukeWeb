<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="cvcOfferMoneyList" checkbox="false" pagination="true" fitColumns="false" collapsible="false" title="报价表" actionUrl="cvcOfferMoneyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="商品名称"  field="goodName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否本公司"  field="ifMyCompany"  queryMode="single" hidden="true"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="销售不含税价"  field="xiaoshoubuhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售的增值税"  field="xiaoshoudezhengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="销售含税价"  field="xiaoshouhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购不含税价"  field="caigoubuhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购的增值税"  field="caigoudezengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购的含税价"  field="caigoudehanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运费不含税价"  field="yunfeibuhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运费增值税"  field="yunfeizengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运费含税价"  field="yunfeihanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="包装费不含税价"  field="baozhuangfeibuhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="包装费增值税"  field="baozhuangfeizengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="包装费含税价"  field="baozhuangfeihanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装卸费不含税价"  field="zhuangxiefeibuhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装卸费增值税"  field="zhuangxiefeizengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装卸费含税价"  field="zhuangxiefeihanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓储费不含税价"  field="cangchufeibuhanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓储费增值税"  field="cangchufeizengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="仓储费含税价"  field="cangchufeihanshuijia"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本次货物缴纳的增值税"  field="bencihuowunashuidezengzhishui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="增值税附加税"  field="zengzhishuifujiashui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经营成本标准"  field="jinyingchenbenbiaozhun"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单经营成本"  field="bendanjinyinchengben"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单收入"  field="bendanshouru"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单成本"  field="bendanchengben"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单利润"  field="bendanlirun"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单所得税"  field="bendansuodeshui"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单净利润"  field="bendanjinlirun"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单现金流入"  field="bendanxianjinliuru"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单成本现金流出"  field="bendanchenbenxianjinliuchu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单净现金流"  field="bendanjinxianjinliu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单税金流出"  field="bendanshuijinliuchu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单毛利率"  field="bendanmaolilv"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单单位产品不含税售价"  field="bendandanweichanpinbuhssj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本单单位产品含税售价"  field="bendandanweichanpinhssj"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="cvcOfferMoneyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
<%--    <t:dgToolBar title="录入" icon="icon-add" url="cvcOfferMoneyController.do?goAdd" funname="add"></t:dgToolBar> --%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="cvcOfferMoneyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="cvcOfferMoneyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="cvcOfferMoneyController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="上传报价excel" icon="icon-put" url="cvcOfferMoneyController.do?toUpload" width="600" height="300" funname="add" ></t:dgToolBar>
<%--    <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar> --%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   
   <t:dgToolBar title="利润上调" icon="icon-add" url="cvcOfferMoneyController.do?goUpdateValue&name=上调" funname="toUpdate"></t:dgToolBar>
   <t:dgToolBar title="利润下调" icon="icon-add" url="cvcOfferMoneyController.do?goUpdateValue&name=下调" funname="toUpdate"></t:dgToolBar>
<%--    <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/xuzy/hotel/offermoney/cvcOfferMoneyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
		function toUpdate(title, url, id, width, height, isRestful) {
			var rowsData = $('#' + id).datagrid('getSelections');
			if (!rowsData || rowsData.length == 0) {
				tip('请选择操作订单');
				return;
			}
			if (rowsData.length > 1) {
				tip('请选择一条订单再操作');
				return;
			}
			if (isRestful != 'undefined' && isRestful) {
				url += '/' + rowsData[0].id;
			} else {
				url += '&id=' + rowsData[0].id;
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
			openuploadwin('Excel导入', 'cvcOfferMoneyController.do?upload',
					"cvcOfferMoneyList");
		}

		//导出
		function ExportXls() {
			JeecgExcelExport("cvcOfferMoneyController.do?exportXls",
					"cvcOfferMoneyList");
		}

		//模板下载
		function ExportXlsByT() {
			JeecgExcelExport("cvcOfferMoneyController.do?exportXlsByT",
					"cvcOfferMoneyList");
		}
	</script>