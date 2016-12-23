package com.turingoal.cms.modules.ext.web.controller.admin;

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
import com.turingoal.cms.modules.ext.domain.AdSlot;
import com.turingoal.cms.modules.ext.domain.form.AdSlotForm;
import com.turingoal.cms.modules.ext.domain.query.AdSlotQuery;
import com.turingoal.cms.modules.ext.service.AdSlotService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 广告位Controller
 */
@Controller
@RequestMapping("/m/ext/adSlot")
public class AdSlotController {
    private static final String LIST_PAGE = "modules/site/adSlot/list";
    private static final String ADD_PAGE = "modules/site/adSlot/add";
    private static final String EDIT_PAGE = "modules/site/adSlot/edit";

    @Autowired
    private AdSlotService adSlotService;

    /**
     * 返回广告位查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage(final AdSlotQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        Page<AdSlot> result = adSlotService.findAll(query);
        mav.addObject("adSlotList", new PageGridBean(query, result, true));
        return mav;
    }

    /**
     * 返回广告位查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final AdSlotQuery query) throws BusinessException {
        Page<AdSlot> result = adSlotService.findAll(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 AdSlot
     */
    @RequestMapping(value = "/get.gsp")
    @ResponseBody
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return adSlotService.get(id);
    }

    /**
     * 返回广告位新增界面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增广告位
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final AdSlotForm form, final BindingResult bindingResult) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { adSlotService.add(form); return new JsonResultBean(JsonResultBean.SUCCESS); }
         */
        adSlotService.add(form);
        return "redirect:/admin/m/ext/adSlot/list.gsp";
    }

    /**
     * 返回广告位修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", adSlotService.get(id));
        return mav;
    }

    /**
     * 返回广告位修改界面
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final AdSlotForm form, final BindingResult bindingResult) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { adSlotService.update(form); return new JsonResultBean(JsonResultBean.SUCCESS); }
         */
        adSlotService.update(form);
        return "redirect:/admin/m/ext/adSlot/list.gsp";
    }

    /**
     * 根据id删除 广告位
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        adSlotService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用广告位
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        adSlotService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用广告位
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        adSlotService.disable(id);
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