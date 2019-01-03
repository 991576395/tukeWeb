<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->


    <title>首页</title>

    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in-ui/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="plug-in-ui/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in-ui/hplus/css/style.css?v=4.1.0" rel="stylesheet">


</head>

<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">
            <h4 class="text-danger">首页</h4>
        </blockquote>
        <hr>
    </div>
    
</div>

<!-- 全局js -->
<script src="plug-in-ui/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in-ui/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="plug-in-ui/hplus/js/content.js"></script>
</body>

<script type="text/javascript">
		function tipAlert(title,id){
			layer.open({
				title:"系统提示",
				content:title,
				icon:7,
				shade: 0.3,
				yes:function(index){
					layer.close(index);
					//修改已读
					request("cvcMessageTableController.do?setRead&id="+id,function(data){
					});
				},
				btn:['已读','忽略'],
				btn2:function(index){
					layer.close(index);
				}
			});
		}
		
		$(document).ready(function(){
			//判断是否需要提示信息
			request("cvcInventoryTableController.do?checkIfWillAlter",function(data){
				if(data.obj.length > 0){
					for(var i = 0 ;i < data.obj.length; i++){
						tipAlert(data.obj[0].messageContent,data.obj[0].id);
					}
				}
			});
		});
		
		
	//请求
	function request(url, fn) {
		$.ajax({
			url : url,
			type : 'post',
			cache : false,
			success : function(data) {
				var d = $.parseJSON(data);
				var msg = d.msg;
				if (d.success) {
					fn.call(this,d);
				}
			}
		});
	}
</script>
</html>
