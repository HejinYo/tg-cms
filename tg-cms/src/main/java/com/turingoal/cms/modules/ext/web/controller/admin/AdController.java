package com.turingoal.cms.modules.ext.web.controller.admin;

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
import com.github.pagehelper.Page;
import com.turingoal.cms.modules.ext.domain.Ad;
import com.turingoal.cms.modules.ext.domain.AdSlot;
import com.turingoal.cms.modules.ext.domain.form.AdForm;
import com.turingoal.cms.modules.ext.domain.query.AdQuery;
import com.turingoal.cms.modules.ext.domain.query.AdSlotQuery;
import com.turingoal.cms.modules.ext.service.AdService;
import com.turingoal.cms.modules.ext.service.AdSlotService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 广告管理Controller
 */
@Controller
@RequestMapping("/m/ext/ad")
public class AdController {

    private static final String LIST_PAGE = "modules/content/ad/list";
    private static final String ADD_PAGE = "modules/content/ad/add";
    private static final String EDIT_PAGE = "modules/content/ad/edit";

    @Autowired
    private AdService adService;
    @Autowired
    private AdSlotService adSlotService;

    /**
     * 返回广告管理查询界面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView listPage(final AdQuery query) throws BusinessException {
        ModelAndView mav = new ModelAndView(LIST_PAGE);
        AdSlotQuery dSlotaquery = new AdSlotQuery();
        Page<Ad> result = adService.findAll(query);
        mav.addObject("slot", adSlotService.findList(dSlotaquery));
        mav.addObject("adList", new PageGridBean(query, result, true));
        return mav;
    }

    /**
     * 返回广告管理查询信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean list(final AdQuery query) throws BusinessException {
        Page<Ad> result = adService.findAll(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 广告信息
     */
    @RequestMapping(value = "/get.gsp")
    @ResponseBody
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return adService.get(id);
    }

    /**
     * 返回广告管理新增界面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        AdSlotQuery adSlotQuery = new AdSlotQuery();
        List<AdSlot> adSlot = adSlotService.findAll(adSlotQuery);
        mav.addObject("result", adSlot);
        return mav;
    }

    /**
     * 新增广告信息
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final AdForm form, final BindingResult bindingResult) throws BusinessException {
        adService.add(form);
        return "redirect:/admin/m/ext/ad/list.gsp";
    }

    /**
     * 返回广告管理修改界面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", adService.get(id));
        AdSlotQuery adSlotQuery = new AdSlotQuery();
        List<AdSlot> adSlot = adSlotService.findAll(adSlotQuery);
        mav.addObject("adSlot", adSlot);
        return mav;
    }

    /**
     * 返回广告管理修改界面
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String edit(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final AdForm form, final BindingResult bindingResult) throws BusinessException {
        adService.update(form);
        return "redirect:/admin/m/ext/ad/list.gsp";
    }

    /**
     * 根据id删除 广告信息
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean delete(@PathVariable("id") final String id) throws BusinessException {
        adService.delete(id);
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