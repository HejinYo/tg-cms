$(document).ready(function() {
    // 刷新验证码
    $("#captchaImg").click(function() {
        $(this).attr("src", $(this).attr("src") + "?a=" + new Date());
    });
    var validator = $("#loginForm").validate({
        // 错误信息高亮
        highlight : function(element) {
            $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
        },
        // 去掉高亮显示
        unhighlight : function(element) {
            $(element).closest('.form-group').removeClass('has-error');
        },
        // 显示错误信息位置
        errorLabelContainer : "#validateMsg",
        rules : {
            tg_username : {
                required : true,
                minlength : 3,
                maxlength : 25
            },
            tg_password : {
                required : true,
                minlength : 6,
                maxlength : 25
            },
            tg_captchaCode : {
                required : true,
                maxlength : 5,
                minlength : 5
            }
        },
        messages : {
            tg_username : {
                required : "请输入您的用户名.",
                minlength : "用户名必须3个字符以上.",
                maxlength : "用户名不能大于25个字符."
            },
            tg_password : {
                required : "请输入您的密码.",
                minlength : "密码必须6个字符以上.",
                maxlength : "密码不能大于25个字符."
            },
            tg_captchaCode : {
                required : "请输入您的验证码.",
                minlength : "验证码必须5个字符.",
                maxlength : "验证码必须5个字符."
            }
        }
    });
    // 点击重置按钮清除错误信息
    $("#resetBtn").click(function() {
        $(".has-error").removeClass('has-error');
        validator.resetForm();
    });
});
