package com.turingoal.cms.core.web.controller.fore;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.commons.SystemHelper;

/**
 * 前台系统登录，退出
 */
@Controller
public class ForeLoginController {

    /**
     * 跳转到拒绝访问页面
     */
    @RequestMapping(value = "/denied.htm")
    public ModelAndView denied() {
        ModelAndView model = new ModelAndView("denied");
        // 传递用户名到页面中
        model.addObject("username", SystemHelper.getCurrentUsername());
        return model;
    }

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
