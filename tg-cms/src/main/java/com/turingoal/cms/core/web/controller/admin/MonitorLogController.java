package com.turingoal.cms.core.web.controller.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.Page;
import com.turingoal.cms.core.domain.LogInfo;
import com.turingoal.cms.core.domain.query.LogInfoQuery;
import com.turingoal.cms.core.service.MonitorLogInfoService;
import com.turingoal.common.bean.PageGridBean;
import com.turingoal.common.constants.ConstantDateFormatTypes;
import com.turingoal.common.exception.BusinessException;

/**
 * 日志
 */
@Controller
@RequestMapping("/c/monitor/log")
public class MonitorLogController {
    private static final String LIST_LOGIN_PAGE = "core/monitor/logLoginList";
    private static final String LIST_OPERAGE_PAGE = "core/monitor/logOperateList";
    @Autowired
    private MonitorLogInfoService loginfoService;

    /**
     * 登录日志页面
     */
    @RequestMapping(value = "/listLogin.gsp", method = RequestMethod.GET)
    public String listLoginPage() throws BusinessException {
        return LIST_LOGIN_PAGE;
    }

    /**
     * 登录日志分页查询
     */
    @RequestMapping(value = "/listLogin.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean listLogin(final LogInfoQuery query) throws BusinessException {
        Page<LogInfo> result = loginfoService.findLoginLogByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 操作日志页面
     */
    @RequestMapping(value = "/listOperate.gsp", method = RequestMethod.GET)
    public String listtOperatePage() throws BusinessException {
        return LIST_OPERAGE_PAGE;
    }

    /**
     * 操作日志分页查询
     */
    @RequestMapping(value = "/listOperate.gsp", method = RequestMethod.POST)
    @ResponseBody
    public PageGridBean listtOperate(final LogInfoQuery query) throws BusinessException {
        Page<LogInfo> result = loginfoService.findOperateLogByPage(query);
        return new PageGridBean(query, result, true);
    }

    /**
     * 将form表单里面的String Date转换成Date型，字符串去掉空白
     */
    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(ConstantDateFormatTypes.YYYY_MM_DD_HH24_MM_SS), true));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
