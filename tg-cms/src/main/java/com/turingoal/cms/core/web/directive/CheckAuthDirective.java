package com.turingoal.cms.core.web.directive;

/**
 * CommentDirective
 */
public interface CheckAuthDirective {

    /**
     * 检查用户是否具有某个权限
     * 
     * @param authName
     *            权限标识
     */
    Boolean checkAuth(final String authName);

}