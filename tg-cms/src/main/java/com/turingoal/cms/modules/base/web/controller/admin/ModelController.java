package com.turingoal.cms.modules.base.web.controller.admin;

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
import com.turingoal.cms.modules.base.domain.Model;
import com.turingoal.cms.modules.base.domain.form.ModelForm;
import com.turingoal.cms.modules.base.domain.query.ModelQuery;
import com.turingoal.cms.modules.base.service.ModelService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * 模型Controller
 */
@Controller
@RequestMapping("/m/base/model")
public class ModelController {
    private static final String LIST_PAGE = "modules/config/model/list";
    private static final String ADD_PAGE = "modules/config/model/add";
    private static final String EDIT_PAGE = "modules/config/model/edit";
    private static final String COPY_PAGE = "modules/config/model/copy";

    @Autowired
    private ModelService modelService;

    /**
     * 模型列表页面
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public final String listPage() throws BusinessException {
        return LIST_PAGE;
    }

    /**
     * 查询全部 模型
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final PageGridBean list(final ModelQuery query) throws BusinessException {
        List<Model> result = modelService.findAll(query);
        return new PageGridBean(result);
    }

    /**
     * 通过id得到一个 模型
     */
    @RequestMapping(value = "/get")
    @ResponseBody
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return modelService.get(id);
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public final String addPage() {
        return ADD_PAGE;
    }

    /**
     * 新增 模型
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final ModelForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            modelService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        mav.addObject("result", modelService.get(id));
        return mav;
    }

    /**
     * 修改 模型
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final ModelForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            modelService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 复制页面
     */
    @RequestMapping(value = "/copy_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView copyPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(COPY_PAGE);
        mav.addObject("result", modelService.get(id));
        return mav;
    }

    /**
     * 复制模型
     */
    @RequestMapping(value = "/copy.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean copy(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final ModelForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            modelService.addAndCopy(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 模型
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        modelService.delete(id);
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