var $ = layui.jquery;
// 操作成功
function tg_alertSuccess(message) {
    layer.msg(!message ? '恭喜您，操作成功！' : message, {
        time : 1000,
        icon : 1
    });
}
// 系统消息
function tg_alertInfo(message) {
    layer.msg(!message ? '系统消息!' : message, {
        time : 1000,
        icon : 1
    });
}
// 系统警告
function tg_alertWarning(message) {
    layer.msg(!message ? '系统警告！' : message, {
        time : 1000,
        icon : 1
    });
}
// 系统错误
function tg_alertError(message) {
    layer.msg(!message ? '对不起，操作失败！' : message, {
        time : 1000,
        icon : 1
    });
}
// tg_confirmDialog
function tg_confirmDialog(title, message, okCallbackFun, cancelCallbackFun) {
    layer.confirm(!message ? '您确定要执行该操作吗？！' : message, {
        title : !title ? '操作确认' : title,
        icon : 3, // 问号图标
        btn : [ '确定', '取消' ]
    }, function() {
        // 确定按钮操作
        if (okCallbackFun) {
            okCallbackFun();
        }
        layer.closeAll(); // 关闭layer
    }, function() {
        // 取消按钮操作
        if (cancelCallbackFun) {
            cancelCallbackFun();
        }
    });
}
// 删除
function tg_deleteItem(url, sucCallbackFun, failCallbackFun) {
    var okCallbackFun = function() {
        tg_simpleAjaxPost(url, null, sucCallbackFun, failCallbackFun);
    };
    tg_confirmDialog(null, "您确定要删除该条数据吗？", okCallbackFun);
}
// 简单Ajax Post操作数据
function tg_simpleAjaxPost(url, parms, sucCallbackFun, failCallbackFun) {
    $.ajax({
        url : url,
        type : 'POST',
        data : parms,
        error : function() {
            tg_alertError();
        },
        success : function(d) {
            var result = $.parseJSON(d);
            if (result.success) {
                if (sucCallbackFun) {
                    sucCallbackFun(d); // 回调函数
                } else {
                    tg_alertSuccess();
                }
            } else {
                if (failCallbackFun) {
                    failCallbackFun(d); // 回调函数
                } else {
                    tg_alertError('操作失败', result.msg);
                }
            }
        }
    });
}
function tg_basePage(option) {
    layui.use([ 'laypage', 'layer' ], function() {
        var baseUrl = option.listUrl;
        for(var item in option.param){
            if($("#"+item).val() != ''){
                baseUrl += "&" + item + "=" + $("#"+item).val()
            }
        }        
        var laypage = layui.laypage, layer = layui.layer;
        laypage({
            cont : option.pageDiv == null ? 'pageDiv' : option.pageDiv,
            pages : option.totalPages == null ? 10 : option.totalPages,
            groups : option.group == null ? 5 : option.group,
            curr : option.page == null ? 1 : option.page,
            skip : option.skip == null ? true : option.skip,
            jump : function(obj, first) {
                if (option.page > 0 && obj.curr != option.page) {
                    window.location.href = baseUrl + "&page=" + obj.curr;
                }
            }
        });
    });
}
function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
        return decodeURIComponent(r[2]);
    return null;
}