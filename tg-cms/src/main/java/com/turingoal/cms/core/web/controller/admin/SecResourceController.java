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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.domain.Resource;
import com.turingoal.cms.core.domain.form.ResourceForm;
import com.turingoal.cms.core.service.ResourceService;
import com.turingoal.common.bean.BaseTreeNodeBean;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 资源 ResourceController
 */
@Controller
@RequestMapping("/c/resource")
public class SecResourceController {
    private static final String LIST_PAGE = "core/uum/resource/list";
    private static final String ADD_PAGE = "core/uum/resource/add";
    private static final String EDIT_PAGE = "core/uum/resource/edit";
    @Autowired
    private ResourceService resourceService;

    /**
     * 资源管理页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage() throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        List<Resource> resources = resourceService.findAll();
        mav.addObject("resources", resources);
        return mav;
    }

    /**
     * 资源管理数据
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list() throws BusinessException {
        List<Resource> resources = resourceService.findAll();
        return new PageGridBean(resources);
    }

    /**
     * 查询全部资源树
     */
    @RequestMapping(value = "/tree.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final BaseTreeNodeBean resourceTree() throws BusinessException {
        BaseTreeNodeBean ss = resourceService.getResourceTreeGird();
        System.out.println(ss);
        return resourceService.getResourceTreeGird();
    }

    /**
     * 查询全部 启用的Resource名称树
     */
    @RequestMapping(value = "/getResourceEnabledTree.gsp")
    @ResponseBody
    public final BaseTreeNodeBean getResourceEnabledTree() throws BusinessException {
        return resourceService.getResourceEnabledTree();
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add_{parentId}.gsp", method = RequestMethod.GET)
    public final ModelAndView addPage(@PathVariable("parentId") final String parentId) {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        mav.addObject("parentId", parentId);
        return mav;
    }

    /**
     * 新增 Resource
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final ResourceForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
        } else {
            resourceService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", resourceService.get(id));
        return mav;
    }

    /**
     * 修改 Resource
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final ResourceForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            return new JsonResultBean(JsonResultBean.FAULT, SpringBindingResultWrapper.warpErrors(bindingResult));
        } else {
            resourceService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 Resource
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        resourceService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 Resource
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        resourceService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 Resource
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        resourceService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}