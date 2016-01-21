package com.turingoal.cms.core.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.service.MonitorSysinfoService;

/**
 * 系统信息
 */
@Controller
@RequestMapping("/c/monitor/sysinfo")
public class MonitorSysinfoController {
    @Autowired
    private MonitorSysinfoService sysinfoService;

    /**
     * 系统信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getInfo(final HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("core/monitor/sysinfoMonitorList");
        mav.addObject("resultList", sysinfoService.getInfo(request));
        return mav;
    }

    /**
     * 系统信息
     */
    @RequestMapping(value = "/jspEnv")
    public String home() {
        return "core/monitor/jspenv";
    }
}
