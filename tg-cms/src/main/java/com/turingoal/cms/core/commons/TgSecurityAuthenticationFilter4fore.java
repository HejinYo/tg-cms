package com.turingoal.cms.core.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 实现验证码
 */
public class TgSecurityAuthenticationFilter4fore extends UsernamePasswordAuthenticationFilter {

    /**
     * 认证
     */
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {
        return super.attemptAuthentication(request, response);
    }
}