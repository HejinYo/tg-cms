package com.turingoal.cms.modules.ext.web.controller.admin;

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
import com.turingoal.cms.modules.ext.domain.ScoreRecord;
import com.turingoal.cms.modules.ext.domain.form.ScoreRecordForm;
import com.turingoal.cms.modules.ext.domain.query.ScoreRecordQuery;
import com.turingoal.cms.modules.ext.service.ScoreRecordService;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantPattern4Date;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.support.spring.SpringBindingResultWrapper;
import com.turingoal.common.support.validator.ValidGroupAdd;
import com.turingoal.common.support.validator.ValidGroupUpdate;

/**
 * ScoreRecordController
 */
@RestController
@RequestMapping("/m/ext/scoreRecord")
public class ScoreRecordController {
    @Autowired
    private ScoreRecordService scoreRecordService;

    /**
     * 查询全部 ScoreRecord
     */
    @RequestMapping(value = "/findAll")
    public Object findAll(final ScoreRecordQuery query) throws BusinessException {
        return scoreRecordService.findAll(query);
    }

    /**
     * 分页查询 ScoreRecord
     */
    @RequestMapping(value = "/findByPage")
    public PageGridBean findByPage(final ScoreRecordQuery query) throws BusinessException {
        Page<ScoreRecord> result = scoreRecordService.findByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 通过id得到一个 ScoreRecord
     */
    @RequestMapping(value = "/get")
    public Object get(@RequestParam("id") final String id) throws BusinessException {
        return scoreRecordService.get(id);
    }

    /**
     * 新增 ScoreRecord
     */
    @RequestMapping(value = "/add")
    public final JsonResultBean add(@Validated({ ValidGroupAdd.class }) @ModelAttribute("form") final ScoreRecordForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            scoreRecordService.add(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 修改 ScoreRecord
     */
    @RequestMapping(value = "/update")
    public final JsonResultBean update(@Validated({ ValidGroupUpdate.class }) @ModelAttribute("form") final ScoreRecordForm form, final BindingResult bindingResult) throws BusinessException {
        // 数据校验
        if (bindingResult.hasErrors()) {
            String errorMsg = SpringBindingResultWrapper.warpErrors(bindingResult);
            return new JsonResultBean(JsonResultBean.FAULT, errorMsg);
        } else {
            scoreRecordService.update(form);
            return new JsonResultBean(JsonResultBean.SUCCESS);
        }
    }

    /**
     * 根据id删除 ScoreRecord
     */
    @RequestMapping(value = "/delete")
    public final JsonResultBean delete(@RequestParam("id") final String id) throws BusinessException {
        scoreRecordService.delete(id);
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