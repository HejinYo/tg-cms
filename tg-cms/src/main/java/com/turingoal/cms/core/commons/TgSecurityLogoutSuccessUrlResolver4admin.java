package com.turingoal.cms.core.commons;

import org.springframework.security.core.Authentication;

import com.turingoal.common.support.spring.SpringSecurityAbstractLogoutSuccessUrlResolver;

/**
 * 后台退出成功
 */
public class TgSecurityLogoutSuccessUrlResolver4admin extends SpringSecurityAbstractLogoutSuccessUrlResolver {

    @Override
    public boolean support(final Authentication authentication) {
        return TgSecurityAuthenticationToken4admin.class.isAssignableFrom(authentication.getClass());
    }
}
