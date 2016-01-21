package com.turingoal.cms.modules.base.web.controller.fore;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import com.turingoal.cms.modules.base.service.GlobalService;

/**
 * 前台首页
 */
@Controller
public class ForeIndexController {
    @Autowired
    private TemplateEngineHelper templateEngineHelper;
    @Autowired
    private GlobalService globalService;

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
