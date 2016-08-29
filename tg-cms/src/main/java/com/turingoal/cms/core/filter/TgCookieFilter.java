package com.turingoal.cms.core.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对Cookie进行处理, 加强安全性
 */
public class TgCookieFilter implements Filter {

    /**
     * 执行
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Cookie cookie = cookies[0];
            if (cookie != null) {
                cookie.setSecure(true);
                cookie.setHttpOnly(true);
                resp.addCookie(cookie);
            }
        }
        chain.doFilter(req, resp);
    }

    /**
     * 初始化
     */
    @Override
    public void init(final FilterConfig arg0) throws ServletException {

    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {

    }
}
