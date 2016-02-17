package com.turingoal.cms.core.web.controller.fore;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.cms.modules.base.web.controller.fore.TemplateEngineHelper;

/**
 * 前台首页
 */
@Controller
public class ForeIndexController {
    private static final String MAINTENANCE_PAGE = "maintenance";
    @Autowired
    private TemplateEngineHelper templateEngineHelper;
    @Autowired
    private GlobalService globalService;

    /**
     * 维护页面
     */
    @RequestMapping(value = "/maintenance.htm", method = RequestMethod.GET)
    public ModelAndView maintenance() {
        ModelAndView mav = new ModelAndView(MAINTENANCE_PAGE);
        return mav;
    }

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
     * 跳转到首页
     */
    @RequestMapping("/index.htm")
    public void index(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        templateEngineHelper.process("index", request, response);
    }

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
