<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>批量发货</title>
<t:base type="jquery,easyui,tools"></t:base>

<script type="text/javascript">
	function uploadCallback(result){
		if(!result.success){
			alert(result.msg);
		}
	}
</script>
</head>
<body style="overflow-y: hidden" scroll="no">
	<t:formvalid formid="formobj" layout="div" dialog="true"
		beforeSubmit="upload">
		<td align="right"><label class="Validform_label"> 订单批次号: </label></td>
		<td class="value"><input id="orderBatchNo" name="orderBatchNo"
			type="text" style="width: 150px" class="inputxt" size="30" ignore="ignore" /></td>
			<fieldset class="step">
				<div class="form">
					<t:upload name="fiels" buttonText="选择要导入的文件"
						uploader="cvcShippingBatch.do?importExcel" extend="*.xls;*.xlsx"
						id="file_upload" formData="documentTitle,orderBatchNo" onUploadSuccess="uploadCallback"></t:upload>
				</div>
				<div class="form" id="filediv" style="height: 50px"></div>
			</fieldset>
	</t:formvalid>
</body>
</html>
