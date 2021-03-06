package com.turingoal.cms.core.commons;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.turingoal.common.support.spring.SpringSecurityAbstractAuthenticationTokenResolver;

/**
 * 后台AuthenticationTokenResolver
 */
public class TgSecurityAuthenticationTokenResolver4admin extends SpringSecurityAbstractAuthenticationTokenResolver {

    protected TgSecurityAuthenticationTokenResolver4admin() {
        super();
    }

    @Override
    public Authentication resolve(final HttpServletRequest request) {
        String username = request.getParameter("tg_username");
        if (username != null) {
            username = username.trim();
        }
        String password = request.getParameter("tg_password");
        if (password != null) {
            password = password.trim();
        }
        String captcha = request.getParameter("tg_captchaCode");
        if (captcha != null) {
            captcha = captcha.trim();
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("DOMAIN_ADMIN"));
        TgSecurityAuthenticationToken4admin token = new TgSecurityAuthenticationToken4admin(username, password, authorities, captcha);
        return token;
    }
}