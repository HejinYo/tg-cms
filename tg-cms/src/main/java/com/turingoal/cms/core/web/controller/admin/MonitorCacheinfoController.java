package com.turingoal.cms.core.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.service.MonitorCacheinfoService;

/**
 * 缓存信息
 */
@Controller
@RequestMapping("/c/monitor/cache")
public class MonitorCacheinfoController {
    @Autowired
    private MonitorCacheinfoService cacheinfoService;

    /**
     * 缓存信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView getInfo() {
        ModelAndView mav = new ModelAndView("core/monitor/cacheMonitorList");
        mav.addObject("resultList", cacheinfoService.getInfo());
        return mav;
    }
}
