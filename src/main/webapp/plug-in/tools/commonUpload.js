function commonUpload(callback){
         $.dialog({
                        content: "url:systemController.do?commonUpload",
//                        content: "url:systemController.do?commonWebUpload",
                        lock : true,
                        zIndex: getzIndex(),
                        title:"文件上传",
                        left:'85%',
                        top:'65%',
                        width:700,
                        height: 400,
                        parent:windowapi,
                        cache:false,
                    ok: function(){
                            var iframe = this.iframe.contentWindow;
                            iframe.uploadCallback(callback);
                                return true;
                    },
                    cancelVal: '关闭',
                    cancel: function(){
                    } 
                });
}


function commonUploadRead(callback,url,name,id){
    $.dialog({
                   content: "url:systemController.do?commonUpload&url="+url+"&name="+name+"&id="+id,
//                   content: "url:systemController.do?commonWebUpload",
                   lock : true,
                   zIndex: getzIndex(),
                   title:"文件上传",
                   left:'85%',
                   top:'65%',
                   width:700,
                   height: 400,
                   parent:windowapi,
                   cache:false,
               ok: function(){
                       var iframe = this.iframe.contentWindow;
                       iframe.uploadCallback(callback);
                           return true;
               },
               cancelVal: '关闭',
               cancel: function(){
               } 
           });
}