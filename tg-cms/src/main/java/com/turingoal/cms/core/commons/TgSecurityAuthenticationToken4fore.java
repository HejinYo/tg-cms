package com.turingoal.cms.core.commons;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

/**
 * 前台用户凭证AuthenticationToken
 */
public class TgSecurityAuthenticationToken4fore extends UsernamePasswordAuthenticationToken {
    private static final long serialVersionUID = 1L;
    private String captcha; // 验证码

    public TgSecurityAuthenticationToken4fore(final Object principal, final Object credentials, final Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public TgSecurityAuthenticationToken4fore(final Object principal, final Object credentials, final Collection<? extends GrantedAuthority> authorities, final String captchaParm) {
        super(principal, credentials, authorities);
        this.captcha = captchaParm;
    }

    public String getCaptcha() {
        return captcha;
    }
}