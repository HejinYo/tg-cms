package com.turingoal.cms.core.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.domain.query.UserQuery;
import com.turingoal.cms.core.service.UserService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;
import com.turingoal.common.util.spring.SpringSecurityPasswordUtil;

/**
 * 用户 UserController
 */
@Controller
@RequestMapping("/c/user")
public class SecUserController {
    private static final String LIST_PAGE = "core/uum/user/list";
    private static final String ADD_PAGE = "core/uum/user/add";
    private static final String EDIT_PAGE = "core/uum/user/edit";
    private static final String EDIT_PASS = "core/uum/user/editPass";
    @Autowired
    private UserService userService;

    /**
     * 密码修改
     */
    @RequestMapping(value = "/editPass.gsp", method = RequestMethod.GET)
    public String editPass() {
        return EDIT_PASS;
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/changePassword.gsp", method = RequestMethod.POST)
    public final String changePassword(@RequestParam("oldUserPass") final String oldUserPass, @RequestParam("userPass") final String userPass) throws BusinessException {
        User user = userService.get(SystemHelper.getCurrentUserId());
        if (oldUserPass != null && userPass != null && SpringSecurityPasswordUtil.isPasswordValid(user.getUserPass(), oldUserPass)) {
            userService.updateCurrentUserPass(userPass);
            // return new JsonResultBean(JsonResultBean.SUCCESS);
            return "redirect:/logout";
        } else {
            // return new JsonResultBean(false, "原密码不正确，请重新输入！");
            return "redirect:/admin/c/user/editPass.gsp";
        }
    }

    /**
     * 重置用户密码
     */
    @RequestMapping(value = "/resetPass.gsp")
    @ResponseBody
    public final JsonResultBean resetUserPass(@RequestParam("id") final String id) throws BusinessException {
        userService.resetUserPass(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 检查原密码是否一致
     */
    @RequestMapping(value = "/checkOldPass.htm", method = RequestMethod.POST)
    @ResponseBody
    public final boolean changePassword(@ModelAttribute("oldPass") final String oldPass) {
        User user = userService.get(SystemHelper.getCurrentUserId());
        // 判断原密码是否一致
        return (oldPass != null && SpringSecurityPasswordUtil.isPasswordValid(user.getUserPass(), oldPass));
    }

    /**
     * 用户列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        List<User> result = userService.findAll();
        mav.addObject("userList", result);
        return mav;
    }

    /**
     * 查询用户
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final UserQuery query) throws BusinessException {
        List<User> result = userService.findAll();
        return new PageGridBean(query, result);
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增用户
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final UserForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            // return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
            return "redirect:/admin/c/user/list.gsp";
        } else {
            userService.add(form);
            // return new JsonResultBean(JsonResultBean.SUCCESS);
            return "redirect:/admin/c/user/list.gsp";
        }
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", userService.get(id));
        return mav;
    }

    /**
     * 修改用户
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final UserForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            // return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
            return "redirect:/admin/c/user/list.gsp";
        } else {
            userService.update(form);
            // return new JsonResultBean(JsonResultBean.SUCCESS);
            return "redirect:/admin/c/user/list.gsp";
        }
    }

    /**
     * 修改当前User
     */
    @RequestMapping(value = "/updateCurrentUser.gsp", method = RequestMethod.GET)
    public ModelAndView editCurrentUser() {
        ModelAndView mav = new ModelAndView("core/uum/user/editCurrent");
        mav.addObject("result", userService.get(SystemHelper.getCurrentUserId()));
        return mav;
    }

    /**
     * 修改当前User
     */
    @RequestMapping(value = "/updateCurrentUser.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean editCurrentUser(@ModelAttribute("form") final UserForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
        } else {
            form.setId(SystemHelper.getCurrentUserId());
            userService.updateCurrentUser(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 User
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        userService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用用户
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        userService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用用户
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        userService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantPattern4Date.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
