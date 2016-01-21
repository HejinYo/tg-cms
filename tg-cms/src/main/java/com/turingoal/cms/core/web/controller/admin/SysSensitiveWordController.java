package com.turingoal.cms.core.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.turingoal.cms.core.domain.SensitiveWord;
import com.turingoal.cms.core.domain.form.SensitiveWordForm;
import com.turingoal.cms.core.domain.query.SensitiveWordQuery;
import com.turingoal.cms.core.service.SysSensitiveWordService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.spring.SpringBindingResultWrapper;
import com.turingoal.common.util.validator.ValidGroupAdd;
import com.turingoal.common.util.validator.ValidGroupUpdate;

/**
 * 敏感词Controller
 */
@RestController
@RequestMapping("/c/sensitiveWord")
public class SysSensitiveWordController {
    @Autowired
    private SysSensitiveWordService sysSensitiveWordService;

    /**
     * 分页查询 敏感词
     */
    @RequestMapping(value = "/findByPage")
    public Object findByPage(final SensitiveWordQuery query) throws BusinessException {
        Page<SensitiveWord> result = sysSensitiveWordService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 敏感词
     */
    @RequestMapping(value = "/get")
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return sysSensitiveWordService.get(id);
    }

    /**
     * 新增 敏感词
     */
    @RequestMapping(value = "/add")
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final SensitiveWordForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            sysSensitiveWordService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改 敏感词
     */
    @RequestMapping(value = "/update")
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final SensitiveWordForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            sysSensitiveWordService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 敏感词
     */
    @RequestMapping(value = "/delete")
    public final JsonResultBean delete(@RequestParam("id") final String id) throws BusinessException {
        sysSensitiveWordService.delete(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id启用 敏感词
     */
    @RequestMapping(value = "/enable")
    public final JsonResultBean enable(@RequestParam("id") final String id) throws BusinessException {
        sysSensitiveWordService.enable(id);
        return new JsonResultBean(JsonResultBean.SUCCESS);
    }

    /**
     * 根据id停用 敏感词
     */
    @RequestMapping(value = "/disable")
    public final JsonResultBean disable(@RequestParam("id") final String id) throws BusinessException {
        sysSensitiveWordService.disable(id);
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