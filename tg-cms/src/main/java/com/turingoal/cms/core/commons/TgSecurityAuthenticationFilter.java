package com.turingoal.cms.core.commons;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import com.turingoal.common.util.spring.SpringSecurityAuthenticationTokenResolver;

/**
 * 登录
 */
public class TgSecurityAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private SpringSecurityAuthenticationTokenResolver authenticationTokenResolver; // 默认
    private List<SpringSecurityAuthenticationTokenResolver> tokenResolvers = new ArrayList<SpringSecurityAuthenticationTokenResolver>(); // 多页面登录

    protected TgSecurityAuthenticationFilter(final String defaultFilterProcessesUrl, final SpringSecurityAuthenticationTokenResolver defaultAuthenticationTokenResolver) {
        super(defaultFilterProcessesUrl);
        authenticationTokenResolver = defaultAuthenticationTokenResolver; // 默认的
    }

    /**
     * 认证
     */
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {
        SpringSecurityAuthenticationTokenResolver resolver = authenticationTokenResolver; // 每次先恢复为默认的
        for (SpringSecurityAuthenticationTokenResolver tokenResolver : tokenResolvers) {
            if (tokenResolver.support(request)) {
                resolver = tokenResolver;
            }
        }
        Authentication authentication = resolver.resolve(request);
        return this.getAuthenticationManager().authenticate(authentication);
    }

    public void setTokenResolvers(final List<SpringSecurityAuthenticationTokenResolver> tokenResolversParm) {
        this.tokenResolvers = tokenResolversParm;
    }
}