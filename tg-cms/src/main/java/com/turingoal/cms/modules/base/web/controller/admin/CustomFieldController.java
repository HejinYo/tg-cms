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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.domain.CustomField;
import com.turingoal.cms.core.domain.form.CustomFieldForm;
import com.turingoal.cms.core.domain.query.CustomFieldQuery;
import com.turingoal.cms.core.service.CustomFieldService;
import com.turingoal.cms.modules.base.domain.Model;
import com.turingoal.cms.modules.base.service.ModelService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.validator.ValidGroupAdd;

/**
 * 模型Controller
 */
@Controller
@RequestMapping("/m/base/customField")
public class CustomFieldController {
    private static final String FIELDS_PAGE = "modules/config/model/fields";
    private static final String ADD_PAGE = "modules/config/model/addField";
    private static final String EDIT_PAGE = "modules/config/model/editField";

    @Autowired
    private ModelService modelService;
    @Autowired
    private CustomFieldService customFieldService;

    private static Model model;
    private static String fieldsId;

    /**
     * 字段管理
     */
    @RequestMapping(value = "/fields_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView fields(@PathVariable final String id, final CustomFieldQuery query) {
        ModelAndView mav = new ModelAndView(FIELDS_PAGE);
        model = modelService.get(id);
        fieldsId = id;
        mav.addObject("result", model);
        // 将属于该模型的字段显示出来
        query.setOwnerType(model.getType() + "Model");
        query.setOwnerId(id);
        List<CustomField> cusList = customFieldService.findFieldAndValueByModel(query);
        mav.addObject("cusList", cusList);
        // 获取所有的系统字段
        List<CustomFieldForm> sysList = customFieldService.findSysField(id, model.getType());
        mav.addObject("sysList", sysList);
        return mav;
    }

    /**
     * 新增页面
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView mav = new ModelAndView(ADD_PAGE);
        mav.addObject("model", model);
        return mav;
    }

    /**
     * 新增模型字段
     */
    @RequestMapping(value = "/add.gsp", method = RequestMethod.POST)
    public final String modelFieldAdd(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final CustomFieldForm form, final BindingResult bindingResult) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { customFieldService.add(form); return new JsonResultBean(JsonResultBean.SUCCESS); }
         */
        customFieldService.add(form);
        return "redirect:/admin/m/base/customField/fields_" + fieldsId + ".gsp";
    }

    /**
     * 修改页面
     */
    @RequestMapping(value = "/edit_{id}.gsp", method = RequestMethod.GET)
    public final ModelAndView editPage(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView(EDIT_PAGE);
        CustomField cus = customFieldService.get(id);
        mav.addObject("result", cus);
        return mav;
    }

    /**
     * 修改 模型字段
     */
    @RequestMapping(value = "/edit.gsp", method = RequestMethod.POST)
    public final String modelFieldEdit(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final CustomFieldForm form, final BindingResult bindingResult) throws BusinessException {
        /*
         * // 数据校验 if (bindingResult.hasErrors()) { String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult); return new JsonResultBean(JsonResultBean.FAULT, errorMsg); } else { customFieldService.update(form); return new JsonResultBean(JsonResultBean.SUCCESS); }
         */
        customFieldService.update(form);
        return "redirect:/admin/m/base/customField/fields_" + fieldsId + ".gsp";
    }

    /**
     * 获取所有模型字段 带输入值 ownerType 模型类型 ownerId 模型id valueOwnerId 文档/栏目/专题 id
     */
    @RequestMapping(value = "/findFieldAndValueByModel.gsp", method = RequestMethod.POST)
    @ResponseBody
    public JsonResultBean findFieldAndValueByModel(final CustomFieldQuery query) throws BusinessException {
        return new JsonResultBean(customFieldService.findFieldAndValueByModel(query));
    }

    /**
     * 获取所有模型字段
     */
    @RequestMapping(value = "/findFieldByModel.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean findFieldByModel(final CustomFieldQuery query) throws BusinessException {
        List<CustomField> result = customFieldService.findAll(query);
        return new PageGridBean(result);
    }

    /**
     * 获取所有系统模型字段
     */
    @RequestMapping(value = "/findSysField.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean findSysField(final String modelId, final String modelType) {
        List<CustomFieldForm> result = customFieldService.findSysField(modelId, modelType);
        return new PageGridBean(result);
    }

    /**
     * 删除模型字段
     */
    @RequestMapping(value = "/delete_{id}.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean deleteById(@PathVariable("id") final String id) throws BusinessException {
        customFieldService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 校验模型字段
     */
    @RequestMapping(value = "/validateField")
    @ResponseBody
    public final JsonResultBean validateField(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final CustomFieldForm form) throws BusinessException {
        boolean isExist = customFieldService.validateField(form);
        if (isExist) {
            return new JsonResultBean(JsonResultBean.FAULT, "数据已存在！");
        } else {
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 新增系统字段
     */
    @RequestMapping(value = "/addSysField.gsp", method = RequestMethod.POST)
    @ResponseBody
    public final JsonResultBean addSysField(final String fieldName, final String ownerType, final String ownerId) {
        customFieldService.addSysField(fieldName, ownerType, ownerId);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 删除 系统字段
     */
    @RequestMapping(value = "/deleteSysField")
    @ResponseBody
    public final JsonResultBean deleteSysField(final CustomFieldForm form) throws BusinessException {
        customFieldService.deleteSysField(form);
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