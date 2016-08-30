package com.turingoal.cms.core.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.turingoal.common.util.net.XSSRequestWrapper;

/**
 * XSS（跨站脚本攻击）Filter，预防XSS攻击
 */
public class TgXSSFilter implements Filter {

    /**
     * 执行
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
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
