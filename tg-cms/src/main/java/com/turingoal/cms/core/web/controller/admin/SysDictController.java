package com.turingoal.cms.core.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.Page;
import com.turingoal.cms.core.domain.Dict;
import com.turingoal.cms.core.domain.form.DictForm;
import com.turingoal.cms.core.domain.query.DictQuery;
import com.turingoal.cms.core.service.SysDictService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * DictController
 */
@RestController
@RequestMapping("/c/dict")
public class SysDictController {
    @Autowired
    private SysDictService dictService;

    /**
     * 根据字典类型查询启用的数据字典
     */
    @RequestMapping(value = "/findEnabledByType")
    public List<Dict> findEnabledByType(final String dictType) throws BusinessException {
        return dictService.findEnabledByType(dictType);
    }

    /**
     * 分页查询数据字典
     */
    @RequestMapping(value = "/findByPage")
    public Object findByPage(final DictQuery query) throws BusinessException {
        Page<Dict> result = dictService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 根据id获得一个数据字典
     */
    @RequestMapping(value = "/get")
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return dictService.get(id);
    }

    /**
     * 新增数据字典
     */
    @RequestMapping(value = "/add")
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final DictForm form, final BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            dictService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改数据字典
     */
    @RequestMapping(value = "/update")
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final DictForm form, final BindingResult bindingResult) throws BusinessException {
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            dictService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除数据字典
     */
    @RequestMapping(value = "/delete")
    public final JsonResultBean delete(@RequestParam("id") final String id) throws BusinessException {
        dictService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用数据字典
     */
    @RequestMapping(value = "/enable")
    public final JsonResultBean enable(@RequestParam("id") final String id) throws BusinessException {
        dictService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用数据字典
     */
    @RequestMapping(value = "/disable")
    public final JsonResultBean disable(@RequestParam("id") final String id) throws BusinessException {
        dictService.disable(id);
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