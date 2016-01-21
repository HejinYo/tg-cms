package com.turingoal.cms.core.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.cms.core.service.MonitorThreadService;

/**
 * 线程信息
 */
@Controller
@RequestMapping("/c/monitor/thread")
public class MonitorThreadController {
    @Autowired
    private MonitorThreadService threadService;

    /**
     * 线程信息
     */
    @RequestMapping(value = "/list.gsp", method = RequestMethod.GET)
    public ModelAndView getInfo() {
        ModelAndView mav = new ModelAndView("core/monitor/threadMonitorList");
        mav.addObject("result", threadService.getInfo());
        return mav;
    }
}
