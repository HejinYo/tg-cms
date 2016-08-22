package com.turingoal.cms.core.commons;

import org.springframework.security.core.Authentication;

import com.turingoal.common.util.spring.SpringSecurityAbstractLogoutSuccessUrlResolver;

/**
 * 前台退出成功
 */
public class TgSecurityLogoutSuccessUrlResolver4fore extends SpringSecurityAbstractLogoutSuccessUrlResolver {

    @Override
    public boolean support(final Authentication authentication) {
        return TgSecurityAuthenticationToken4fore.class.isAssignableFrom(authentication.getClass());
    }
}
