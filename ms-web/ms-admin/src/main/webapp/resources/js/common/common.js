/**
 * 前台公共脚本封装
 */
(function(Utils){
    Utils.verify = {};
    /** 获取项目根路径 **/
    Utils.root = function(){
        // 获取当前网址，如： http://localhost:8088/test/test.jsp
        var curPath = window.document.location.href;
        //获取主机地址之后的目录，如： test/test.jsp
        var pathName = window.document.location.pathname;
        var pos = curPath.indexOf(pathName);
        //获取主机地址，如： http://localhost:8088
        var localhostPath = curPath.substring(0, pos);
        //获取带"/"的项目名，如：/test
        var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
        return (localhostPath + projectName);//发布前用此
    }

    Utils.confirm = function(params){
        var model = $('#common_confirm_modal');
        model.modal({
            show:true,//显示弹出层
            backdrop:'static',//禁止位置关闭
            keyboard:false //关闭键盘事件
        });
        model.find('.title').html(params.title);
        model.find('.message').html(params.message);

        model.find(".ok").on("click",function(){
            params.operate(true)
        })
        model.find(".cancel").on("click",function(){
            params.operate(false)
        })
    }

})(window.Utils=window.Utils||{});
