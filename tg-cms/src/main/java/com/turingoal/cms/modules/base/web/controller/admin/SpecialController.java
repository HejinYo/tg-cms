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
import com.turingoal.cms.modules.base.domain.Info;
import com.turingoal.cms.modules.base.domain.Special;
import com.turingoal.cms.modules.base.domain.form.InfoForm;
import com.turingoal.cms.modules.base.domain.form.SpecialForm;
import com.turingoal.cms.modules.base.domain.query.InfoQuery;
import com.turingoal.cms.modules.base.domain.query.SpecialQuery;
import com.turingoal.cms.modules.base.domain.query.SpecialTypeQuery;
import com.turingoal.cms.modules.base.service.InfoService;
import com.turingoal.cms.modules.base.service.ModelService;
import com.turingoal.cms.modules.base.service.SpecialService;
import com.turingoal.cms.modules.base.service.SpecialTypeService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.net.RequestUtil;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 专题Controller
 */
@Controller
@RequestMapping("/m/base/special")
public class SpecialController {
    private static final String LIST_PAGE = "modules/content/special/list";
    private static final String ADD_PAGE = "modules/content/special/add";
    private static final String EDIT_PAGE = "modules/content/special/edit";
    private static final String INFO_PAGE = "modules/content/special/infos";

    @Autowired
    private SpecialService specialService;
    @Autowired
    private SpecialTypeService specialTypeService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private InfoService infoService;

    /**
     * 专题列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 分页查询 专题
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findByPage(final SpecialQuery query) throws BusinessException {
        Page<Special> result = specialService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个专题
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public final Special get(@RequestParam("id") final String id) throws BusinessException {
        return specialService.get(id);
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public final ModelAndView addPage() {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        mav.addObject("specialTypes", specialTypeService.findAll(new SpecialTypeQuery()));
        mav.addObject("models", modelService.findByType("special"));
        // mav.addObject("")
        return mav;
    }

    /**
     * 新增 专题
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final SpecialForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            specialService.add(form, RequestUtil.getRequestMapWithPrefix(request, "cus_"));
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("specialTypes", specialTypeService.findAll(new SpecialTypeQuery()));
        mav.addObject("models", modelService.findByType("special"));
        mav.addObject("result", specialService.get(id));
        return mav;
    }

    /**
     * 修改 专题
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final SpecialForm form, final BindingResult bindingResult, final HttpServletRequest request) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            specialService.update(form, RequestUtil.getRequestMapWithPrefix(request, "cus_"));
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 专题
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        specialService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 专题
     */
    @RequestMapping(value = "/enable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean enable(@PathVariable("id") final String id) throws BusinessException {
        specialService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 专题
     */
    @RequestMapping(value = "/disable_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean disable(@PathVariable("id") final String id) throws BusinessException {
        specialService.disable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 返回选择文章页面
     */
    @RequestMapping(value = "/infoList_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView infoList(@PathVariable("id") final String id) throws BusinessException {
        ModelAndView mav = new ModelAndView(INFO_PAGE);
        mav.addObject("specialId", id);
        return mav;
    }

    /**
     * 分页查询未选择 Info
     */
    @RequestMapping(value = "/findUnInfoByPage", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findUnInfoByPage(final InfoQuery query) throws BusinessException {
        Page<Info> result = infoService.findUnInfo(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 分页查询已选择 文章
     */
    @RequestMapping(value = "/findInfoByPage", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean findInfoByPage(final InfoQuery query) throws BusinessException {
        Page<Info> result = infoService.findInfo(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 新增 文章、专题关系
     */
    @RequestMapping(value = "/addRelation.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean addRelation(final InfoForm form) throws BusinessException {
        infoService.addRelation(form);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 删除 文章、专题关系
     */
    @RequestMapping(value = "/deleteRelation_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteRelation(@PathVariable("id") final String id) throws BusinessException {
        infoService.deleteRelation(id);
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