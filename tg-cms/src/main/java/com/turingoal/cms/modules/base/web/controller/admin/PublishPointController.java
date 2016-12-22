package com.turingoal.cms.modules.base.web.controller.admin;

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
import com.turingoal.cms.modules.base.domain.PublishPoint;
import com.turingoal.cms.modules.base.domain.form.PublishPointForm;
import com.turingoal.cms.modules.base.domain.query.PublishPointQuery;
import com.turingoal.cms.modules.base.service.PublishPointService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 发布点Controller
 */
@Controller
@RequestMapping("/m/base/publishPoint")
public class PublishPointController {
    private static final String LIST_PAGE = "modules/config/publishPoint/list";
    private static final String ADD_PAGE = "modules/config/publishPoint/add";
    private static final String EDIT_PAGE = "modules/config/publishPoint/edit";

    @Autowired
    private PublishPointService publishPointService;

    /**
     * 发布点列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final ModelAndView listPage(final PublishPointQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        Page<PublishPoint> result = publishPointService.findAll(query);
        mav.addObject("PPList", result);
        return mav;
    }

    /**
     * 查询全部 发布点
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean list(final PublishPointQuery query) throws BusinessException {
        Page<PublishPoint> result = publishPointService.findAll(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 发布点
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public final PublishPoint get(@RequestParam("id") final String id) throws BusinessException {
        return publishPointService.get(id);
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public final String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增 发布点
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final PublishPointForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        // if (bindingResult.hasErrors()) {
        // String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
        // return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        // } else {
        publishPointService.add(form);
        // return new JsonResultBean(JsonResultBean.SUCCESS);
        return "redirect:/admin/m/base/publishPoint/list.gsp";
        // }
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", publishPointService.get(id));
        return mav;
    }

    /**
     * 修改 发布点
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final PublishPointForm form, final BindingResult bindingResult) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else {
         */
        publishPointService.update(form);
        // return new JsonResultBean(JsonResultBean.SUCCESS);
        return "redirect:/admin/m/base/publishPoint/list.gsp";
        // }
    }

    /**
     * 删除 发布点
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        publishPointService.delete(id);
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