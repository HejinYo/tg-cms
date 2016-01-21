package com.turingoal.cms.modules.plug.web.controller.fore;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.cms.modules.base.domain.query.GlobalQuery;
import com.turingoal.cms.modules.base.service.GlobalService;
import com.turingoal.cms.modules.base.web.controller.fore.TemplateEngineHelper;
import com.turingoal.cms.modules.plug.domain.form.ResumeForm;
import com.turingoal.cms.modules.plug.service.ResumeService;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.math.CaptchaUtil;

/**
 * 招聘管理
 */
@Controller
public class ForeResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private GlobalService globalService;
    @Autowired
    private TemplateEngineHelper templateEngineHelper;

    /**
     * 人才登记
     */
    @RequestMapping("/{codeNum}_resume.htm")
    public String resume(@PathVariable final String codeNum, @ModelAttribute("form") final ResumeForm form, final HttpServletRequest request, final HttpServletResponse response) throws BusinessException, IOException {
        Global global = SystemHelper.getGlobal();
        if (global == null) {
            List<Global> gs = globalService.findAll(new GlobalQuery());
            SystemHelper.setGlobal(gs.get(0));
        }
        if (CaptchaUtil.checkCaptcha(request.getSession(), form.getCheckCode())) {
            resumeService.add(form);
        }
        return "redirect:/" + codeNum + "_.htm";
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
