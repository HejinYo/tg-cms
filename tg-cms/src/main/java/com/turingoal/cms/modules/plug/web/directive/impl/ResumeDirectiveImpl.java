package com.turingoal.cms.modules.plug.web.directive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.modules.plug.service.ResumeService;
import com.turingoal.cms.modules.plug.web.directive.ResumeDirective;

/**
 * ResumeDirective
 */
@Component
public class ResumeDirectiveImpl implements ResumeDirective {
    @Autowired
    private ResumeService resumeService;
}