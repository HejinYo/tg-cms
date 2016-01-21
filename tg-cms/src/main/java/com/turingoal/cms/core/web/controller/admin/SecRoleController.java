package com.turingoal.cms.core.web.controller.admin;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.turingoal.cms.core.domain.Role;
import com.turingoal.cms.core.domain.form.RoleForm;
import com.turingoal.cms.core.domain.query.RoleQuery;
import com.turingoal.cms.core.service.ResourceService;
import com.turingoal.cms.core.service.RoleService;
import com.turingoal.common.bean.BaseTreeNodeBean;
import com.turingoal.common.bean.BaseZTreeNodeBean;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 角色 RoleController
 */
@Controller
@RequestMapping("/c/role")
public class SecRoleController {
    private static final String LIST_PAGE = "core/uum/role/list";
    private static final String ADD_PAGE = "core/uum/role/add";
    private static final String EDIT_PAGE = "core/uum/role/edit";
    private static final String AUTHORZE_PAGE = "core/uum/role/roleResource";
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    /**
     * 角色管理页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 查询角色
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final RoleQuery query) throws BusinessException {
        List<Role> result = roleService.findAll();
        return new PageGridBean(query, result);
    }

    /**
     * 查询全部启用的 Role的名称
     */
    @RequestMapping(value = "/findRoleEnabled.gsp")
    public List<Role> findRoleEnabled() throws BusinessException {
        return roleService.findRoleEnabled();
    }

    /**
     * 查询某个角色的所有权限（多选框树）
     */
    @RequestMapping(value = "/getResourceNameTreeByRole.gsp")
    public final ModelAndView getResourceNameTreeByRole(@RequestParam("roleId") final String roleId) throws BusinessException {
        ModelAndView view = new ModelAndView();
        view.setViewName(AUTHORZE_PAGE);
        List<BaseZTreeNodeBean> treeNodeCheckBeans = roleService.getResourceNameTreeByRole(roleId);
        view.addObject("reslurceTree", treeNodeCheckBeans);
        view.addObject("roleId", roleId);
        return view;

    }

    /**
     * 更新某个角色下的权限
     */
    @RequestMapping(value = "/updateResourcesByRole.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean updateResourcesByRole(@RequestParam("id") final String roleId, @RequestParam("resourcesIds") final String resourcesIds) throws BusinessException {
        roleService.updateResourcesByRole(roleId, resourcesIds);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 新增角色
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增 角色
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final RoleForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            roleService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改角色页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", roleService.get(id));
        return mav;
    }

    /**
     * 修改角色
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final RoleForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
        } else {
            roleService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 Role
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        roleService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用角色
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        roleService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用角色
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        roleService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 修改角色页面
     */
    @RequestMapping(value = "/authorize_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView roleAuthorize(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(AUTHORZE_PAGE);
        mav.addObject("result", roleService.get(id));
        return mav;
    }

    /**
     * 查询角色资源树
     */
    @RequestMapping(value = "/tree.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final BaseTreeNodeBean resourceTree(final RoleQuery query) throws BusinessException {
        return resourceService.getResourceTree(query.getId());
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
