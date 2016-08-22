package com.turingoal.cms.core.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.baidu.ueditor.ActionEnter;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.service.MonitorSysinfoService;
import com.turingoal.common.util.math.CaptchaUtil;

/**
 * 系统登录，退出
 */
@Controller
public class SysLoginController {
    @Autowired
    private MonitorSysinfoService sysinfoService;

    /**
     * 跳转到登录页面
     */
    @RequestMapping(value = "/loginPage.gsp", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "type", required = false) final String type, final ModelMap model) {
        if ("error".equals(type)) {
            model.put("errorMsg", "登录失败，请重新登录！");
        } else if ("logout".equals(type)) {
            model.put("errorMsg", "退出成功，请重新登录！");
        } else if ("timeout".equals(type)) {
            model.put("errorMsg", "会话超时，请重新登录！");
        } else if ("expired".equals(type)) {
            model.put("errorMsg", "会话失效，请重新登录！");
        }
        return "login";
    }

    /**
     * 获取验证码
     */
    @RequestMapping(value = "/getCaptcha.gsp")
    public void getImage(final HttpSession session, final HttpServletResponse response) {
        // 生成验证码并放到Session中
        CaptchaUtil.getCaptcha(session, response);
    }

    /**
     * 后台主页
     */
    @RequestMapping(value = "/admin")
    public String admin() {
        return "redirect:admin/index.gsp";
    }

    /**
     * 跳转到主页面
     */
    @RequestMapping(value = "/index.gsp")
    public ModelAndView index(final HttpServletRequest request) {
        ModelAndView mav;
        if (SystemHelper.isAuthenticated()) {
            mav = new ModelAndView("index");
            mav.addObject("resultList", sysinfoService.getInfo(request));
            return mav;
        } else {
            mav = new ModelAndView("redirect:/admin/loginPage.gsp");
            return mav;
        }
    }

    /**
     * ueditor上传
     */
    @RequestMapping(value = "/resources/vendor/ueditor/jsp/controller.gsp")
    @ResponseBody
    public void controller(final HttpServletRequest request, final HttpServletResponse response) {
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        ActionEnter ae = new ActionEnter(request, rootPath);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(ae.exec());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
