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
import org.springframework.web.bind.annotation.ResponseBody;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.commons.TgSecurityPasswordHelper;
import com.turingoal.cms.core.service.ResourceService;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.constants.ConstantSystemValues;
import com.turingoal.common.exception.BusinessException;

/**
 * 系统首页
 */
@Controller
@RequestMapping("/c/index")
public class SysIndexController {
    @Autowired
    private ResourceService resourceService;
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
     * 跳转到关于页面
     */
    @RequestMapping(value = "/about.gsp")
    public String about() {
        return "about";
    }

    /**
     * 查询用户菜单树
     */
    @RequestMapping(value = "/menuTree.gsp")
    @ResponseBody
    public Object menuTree() throws BusinessException {
        return resourceService.findMenusEnabledTreeByUserId(SystemHelper.getCurrentUserId());
    }

    /**
     * 查询用户一级菜单
     */
    @RequestMapping(value = "/getFirstLevelMenus.gsp")
    @ResponseBody
    public Object getFirstLevelMenusByUser() throws BusinessException {
        return resourceService.findFirstLevelMenusEnabledByUserId(SystemHelper.getCurrentUserId());
    }

    /**
     * 查询用户子菜单
     */
    @RequestMapping(value = "/getChildrenMenus.gsp")
    @ResponseBody
    public Object findChildrenMenusByUser(final String parentId) throws BusinessException {
        return resourceService.findChildrenMenusEnabledTreeByUserId(SystemHelper.getCurrentUserId(), parentId);
    }

    /**
     * 锁定系统
     */
    @RequestMapping(value = "/lock.gsp")
    @ResponseBody
    public JsonResultBean lock() {
        SystemHelper.setSessionAttibute(ConstantSystemValues.LOGIN_LOCK, true);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 检查是否锁定系统
     */
    @RequestMapping(value = "/checkLock.gsp")
    @ResponseBody
    public JsonResultBean checkLock() {
        if (SystemHelper.getSessionAttibute(ConstantSystemValues.LOGIN_LOCK) != null) {
            boolean lock = (Boolean) SystemHelper.getSessionAttibute(ConstantSystemValues.LOGIN_LOCK);
            if (lock) {
                return new JsonResultBean(JsonResultBean.SUCCESS);
            }
        }
        return new JsonResultBean(JsonResultBean.FAULT);
    }

    /**
     * 解锁系统
     */
    @RequestMapping(value = "/unlock.gsp")
    @ResponseBody
    public JsonResultBean unlock(final HttpServletRequest request) {
        String password = request.getParameter("password");
        if (password != null) {
            String userPass = SystemHelper.getCurrentUser().getUserPass();
            if (userPass.equals(TgSecurityPasswordHelper.encodePassword(password))) {
                SystemHelper.setSessionAttibute(ConstantSystemValues.LOGIN_LOCK, false);
                return new JsonResultBean();
            }
        }
        return new JsonResultBean(false);
    }

    /**
     * 检查用户是否具有某个权限
     */
//    @RequestMapping(value = "/checkAuth.gsp")
//    @ResponseBody
//    public JsonResultBean checkAuth(@RequestParam("authName") final String authName) {
//        if (SystemHelper.isAuthenticated()) {
//            if (ConstantSystemValues.ADMIN_USER.equals(SystemHelper.getCurrentUsername())) {
//                return new JsonResultBean(JsonResultBean.SUCCESS);
//            } else {
//                if (SystemHelper.isPermitted(authName)) {
//                    return new JsonResultBean(JsonResultBean.SUCCESS);
//                }
//            }
//        }
//        return new JsonResultBean(JsonResultBean.FAULT);
//    }

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
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantDateFormatTypes.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}