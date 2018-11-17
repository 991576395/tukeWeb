<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
 <head>
<t:base type="jquery,easyui,tools"></t:base>
<script type="text/javascript">
        function uploadSuccess(d,file,response){
                $("#fileUrl").val(d.attributes.url);
                $("#fileName").val(d.attributes.name);
                $("#swfpath").val(d.attributes.swfpath);
                $("#fileId").val(d.attributes.id);
                var url = $("#fileUrl").val();
                var html="";
                if(url.indexOf(".gif")!=-1 || 
                                url.indexOf(".jpg")!=-1        ||
                                url.indexOf(".png")!=-1 ||
                                url.indexOf(".bmp")!=-1){
                        html += "<img src='"+url+"' width =400 height=300 />";
                }else{
                        html += "<a href='"+url+"' target=_blank >下载:"+d.attributes.name+"</a>";
                }
                $("#fileShow").html(html);
        }
        function uploadCallback(callback,inputId){
                var url = $("#fileUrl").val();
                var name= $("#fileName").val();
                var swfpath = $("#swfpath").val();
                var fileId = $("#fileId").val();
                callback(url,name,fileId,swfpath);
                
        }
        
       
        
        function GetRequest() {   
			   var url = location.search; //获取url中"?"符后的字串   
			   var theRequest = new Object();   
			   if (url.indexOf("?") != -1) {   
			      var str = url.substr(1);   
			      strs = str.split("&");   
			      for(var i = 0; i < strs.length; i ++) {   
			         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);   
			      }   
		  	 }   
		   return theRequest;   
		}   
</script>
</head>
 <body style="overflow-x: hidden">
  <table cellpadding="0" cellspacing="1" class="formtable">
  <input id="documentTitle" type="hidden" name="documentTitle" value="blank"/>
  <input id="fileId" type="hidden"/>
  <input id="fileUrl" type="hidden"/>
  <input id="fileName" type="hidden"/>
  <input id="swfpath" type="hidden">
   <tbody>
    <tr>
     <td align="right">
       <label class="Validform_label"></label>
     </td>
     <td class="value">
      <t:upload name="instruction" dialog="false" multi="false" extend="" queueID="instructionfile" view="false" auto="true" uploader="cgUploadController.do?ajaxSaveFile" onUploadSuccess="uploadSuccess"  id="instruction" formData="documentTitle"></t:upload>
     </td>
    </tr>
    <tr>
     <td colspan="2" id="instructionfile" class="value">
     </td>
    </tr>
   </tbody>
  </table>
   <div id="fileShow" >
  </div>
 </body>
 </html>
 
 <script type="text/javascript">
 	var theRequest = GetRequest();
	//加载数据
	var url = "";
	var name = "";
	var id = "";
	url = theRequest['url'];
	name = theRequest['name'];
	id = theRequest['id'];
	if (url.length > 0 && name.length > 0 && id.length > 0) {
	    var html = "";
	    if (url.indexOf(".gif") != -1 || url.indexOf(".jpg") != -1 || url.indexOf(".png") != -1 || url.indexOf(".bmp") != -1) {
	        html += "<img src='" + url + "' width =400 height=300 />";
	    } else {
	        html += "<a href='" + url + "' target=_blank >下载:" + name + "</a>";
	    }
	    $("#fileShow").html(html);
	    $("#fileId").val(id);
	    $("#fileUrl").val(url);
	    $("#fileName").val(name);
	}
 
 </script>
