package com.turingoal.cms.core.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.github.pagehelper.Page;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.domain.query.UserQuery;
import com.turingoal.cms.core.service.UserService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.spring.SpringSecurityPasswordUtil;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

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
    @RequestMapping(value = "/changePassword.gsp")
    @ResponseBody
    public final JsonResultBean changePassword(@RequestParam("oldUserPass") final String oldUserPass, @RequestParam("userPass") final String userPass) throws BusinessException {
        if (!SpringSecurityPasswordUtil.isPasswordValid(SystemHelper.getCurrentUserId(), userPass)) {
            return new JsonResultBean(false, "原密码不正确，请重新输入！");
        } else {
            userService.updateCurrentUserPass(userPass);
            return new JsonResultBean(JsonResultBean.SUCCESS);
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
     * 用户列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 分页查询用户
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final UserQuery query) throws BusinessException {
        Page<User> result = userService.findByPage(query);
        return new PageGridBean(query, result, true);
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
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final UserForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
        } else {
            userService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
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
    @ResponseBody
    public final JsonResultBean edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final UserForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
        } else {
            userService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
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
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantDateFormatTypes.YYYY_MM_DD), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
