package com.turingoal.cms.core.web.directive.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.turingoal.cms.core.commons.SystemHelper;
import com.turingoal.cms.core.web.directive.CheckAuthDirective;
import com.turingoal.cms.modules.base.service.CommentService;
import com.turingoal.common.constants.ConstantSystemValues;

/**
 * CommentDirective
 */
@Component
public class CheckAuthDirectiveImpl implements CheckAuthDirective {
    @Autowired
    private CommentService commentService;

    /**
     * 检查用户是否具有某个权限
     */
    public Boolean checkAuth(final String authName) {
        if (SystemHelper.isAuthenticated()) {
            if (ConstantSystemValues.ADMIN_USER.equals(SystemHelper.getCurrentUsername())) {
                return true;
            } else {
                //////////// return SystemHelper.isPermitted(authName);
                System.out.println("");
            }
        }
        return false;
    }
}