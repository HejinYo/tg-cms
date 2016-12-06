package com.turingoal.cms.core.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import jodd.util.StringUtil;

/**
 * 系统首页
 */
@Controller
@RequestMapping("/c/index")
public class SysIndexController {
    @Autowired
    private GlobalService globalService;

    /**
     * 跳转到欢迎界面
     */
    @RequestMapping(value = "/wellcome.gsp")
    public String wellcome() {
        return "wellcome";
    }

    /**
     * 跳转到首页
     */
    @RequestMapping(value = "/home.gsp")
    public String home() {
        return "home";
    }

    /**
     * 跳转到帮助页面
     */
    @RequestMapping(value = "/help.gsp")
    public String help() {
        return "redirect:/files/other/help.pdf";
    }

    /**
     * 跳转到关于页面
     */
    @RequestMapping(value = "/about.gsp")
    public String about() {
        return "about";
    }

    /**
     * 锁定系统
     */
    @RequestMapping(value = "/lock.gsp")
    @ResponseBody
    public JsonResultBean lockScreen() {
        SystemHelper.lockScreen();
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 检查是否锁定系统
     */
    @RequestMapping(value = "/checkLock.gsp")
    @ResponseBody
    public JsonResultBean checkLock() {
        if (SystemHelper.checkLockScreen()) {
            return new JsonResultBean(JsonResultBean.SUCCESS);
        } else {
            return new JsonResultBean(JsonResultBean.FAULT);
        }
    }

    /**
     * 解锁系统
     */
    @RequestMapping(value = "/unlock.gsp")
    @ResponseBody
    public JsonResultBean unlock(@RequestParam("userPass") final String userPass) {
        if (StringUtil.isNotBlank(userPass)) {
            if (SystemHelper.unlockScreen(userPass)) {
                return new JsonResultBean();
            }
        }
        return new JsonResultBean(false);
    }

    /**
     * 检查用户是否具有某个权限
     */
    // @RequestMapping(value = "/checkAuth.gsp")
    // @ResponseBody
    // public JsonResultBean checkAuth(@RequestParam("authName") final String authName) {
    // if (SystemHelper.isAuthenticated()) {
    // if (ConstantSystemValues.ADMIN_USER.equals(SystemHelper.getCurrentUsername())) {
    // return new JsonResultBean(JsonResultBean.SUCCESS);
    // } else {
    // if (SystemHelper.isPermitted(authName)) {
    // return new JsonResultBean(JsonResultBean.SUCCESS);
    // }
    // }
    // }
    // return new JsonResultBean(JsonResultBean.FAULT);
    // }

    /**
     * 检查用户是否具有某些权限
     */
    // @RequestMapping(value = "/checkAuths.gsp")
    // @ResponseBody
    // public JsonResultBean checkAuths(@RequestParam("authNames") final String authNames) {
    // String[] authNs = authNames.split(",");
    // List<String> result = new ArrayList<String>();
    // if (SystemHelper.isAuthenticated()) {
    // if (authNs != null && authNs.length > 0) {
    // for (String authName : authNs) {
    // if (ConstantSystemValues.ADMIN_USER.equals(SystemHelper.getCurrentUsername())) {
    // result.add(authName.trim());
    // } else if (SystemHelper.isPermitted(authName.trim())) {
    // result.add(authName.trim());
    // }
    // }
    // }
    // }
    // return new JsonResultBean(result);
    // }

    /**
     * 将form表单里面的字符串去掉空白
     */
    @InitBinder
    protected void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantPattern4Date.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}