<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>菜名维护</title>
   <t:base type="jquery,easyui,tools,DatePicker"></t:base>
   <script type="text/javascript" src="plug-in/tools/commonUpload.js?version=1.3"></script>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password"  layout="table"  action="tMenuTableController.do?save" >
<!--   callback="jeecgFormFileCallBack@Override" -->
		<input id="id" name="id" type="hidden" value="${tMenuTablePage.id }">
			<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<!--  所属菜类 -->
				<tr>
					<td align="right"><label class="Validform_label"> <t:mutiLang
								langKey="所属菜类" />:
					</label></td>
					<td class="value" nowrap><input id="classfryid"
						name="classfryEntity.id" type="hidden" value="${tMenuTablePage.classfryEntity.id}" /> <input
						name="claafryName" id="claafryName" class="inputxt" value="${tMenuTablePage.classfryEntity.claafryName}"
						readonly="readonly" datatype="*" /> <t:choose
							hiddenName="classfryid" hiddenid="id" textname="claafryName"
							url="tMenuClassfryController.do?choiceClassfry" name="classFryList"
							icon="icon-search" title="所属菜类" isclear="true" isInit="true"></t:choose>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							菜名:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="dish_name" name="dishName" ignore="checked" datatype="*"  value="${tMenuTablePage.dishName}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							库存量:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="uploadifystorage_number" name="storageNumber" ignore="ignore"  value="${tMenuTablePage.storageNumber}" datatype="n" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							描述:
						</label>
					</td>
					<td class="value">
						<input class="inputxt" id="decription" name="decription" ignore="ignore"  value="${tMenuTablePage.decription}" />
						<span class="Validform_checktip"></span>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							参考图片:
						</label>
					</td>
						<td class="value" nowrap><input id="fileid"
							name="fileid.id" type="hidden" value="${tMenuTablePage.fileid.id}" /> <input
							id="file" class="inputxt" value="${tMenuTablePage.fileid.attachmenttitle}"
							readonly="readonly" datatype="*" /> 
							<c:if test="${fn:length(tMenuTablePage.fileid.id)>0 }">
								<a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onClick="commonUploadRead(callBack,'${tMenuTablePage.fileid.realpath}','${tMenuTablePage.fileid.attachmenttitle}','${tMenuTablePage.fileid.id}')">上传</a>
							</c:if>
							<c:if test="${fn:length(tMenuTablePage.fileid.id) == 0}">
								<a href="#" class="easyui-linkbutton" plain="true" icon="icon-add" onClick="commonUpload(callBack)">上传</a>
							</c:if>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
 <script type="text/javascript">
 	function callBack(url,name,inputId,swfpath){
 		$("#fileid").val(inputId);
        $("#file").val(name);
 	}
 </script>
 