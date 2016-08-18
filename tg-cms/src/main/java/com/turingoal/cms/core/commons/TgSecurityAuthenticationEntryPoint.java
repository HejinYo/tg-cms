package com.turingoal.cms.core.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.util.net.RequestUtil;
import com.turingoal.common.util.net.WebUtils;
import com.turingoal.common.util.spring.SpringSecurityDirectUrlResolver;

/**
 * 登录入口。 默认的不支持javascript，需要自定义
 */
public class TgSecurityAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {
    private String defaultLoginPageUrl = "/loginPage.htm"; // 默认登录页面
    private List<SpringSecurityDirectUrlResolver> directUrlResolvers = new ArrayList<SpringSecurityDirectUrlResolver>(); // 多登陆页面

    public TgSecurityAuthenticationEntryPoint(final String loginFormUrl) {
        super(loginFormUrl);
        defaultLoginPageUrl = loginFormUrl; // 默认登录页面赋值
    }

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
        boolean isAjax = RequestUtil.isAjax(request); // 是否Ajax请求
        boolean hasSession = SystemHelper.isAuthenticated();
        if (isAjax && !hasSession) {
            this.transformAjaxRequest(request, response);
        } else {
            String targetUrl = defaultLoginPageUrl; // 每次先恢复为默认的
            // 多登录页面处理
            for (SpringSecurityDirectUrlResolver directUrlResolver : directUrlResolvers) {
                if (directUrlResolver.support(request)) {
                    targetUrl = directUrlResolver.directUrl();
                }
            }
            targetUrl = request.getContextPath() + targetUrl;
            response.sendRedirect(targetUrl);
            // super.commence(request, response, authException);
        }
    }

    /**
     * 把错误信息写到浏览器
     */
    private void transformAjaxRequest(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
        WebUtils.writeToBrowser(new JsonResultBean("Session超时，请重新登录").toString(), response);
    }

    public void setDirectUrlResolvers(final List<SpringSecurityDirectUrlResolver> directUrlResolversParm) {
        this.directUrlResolvers = directUrlResolversParm;
    }
}
