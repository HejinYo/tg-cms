package com.turingoal.cms.core.commons;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.util.net.RequestUtil;
import com.turingoal.common.util.net.WebUtils;

/**
 * 登录入口。 默认的不支持java，需要自定义
 */
public class TgSecurityAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public TgSecurityAuthenticationEntryPoint(final String loginFormUrl) {
        super(loginFormUrl);
    }

    private String foreLoginPageUrl = "/loginPage.htm"; // 前台登录页面
    private String adminLoginPageUrl = "/admin/loginPage.gsp"; // 后台登录页面

    public void setForeLoginPageUrl(final String foreLoginPageUrlParm) {
        this.foreLoginPageUrl = foreLoginPageUrlParm;
    }

    public void setAdminLoginPageUrl(final String adminLoginPageUrlParm) {
        this.adminLoginPageUrl = adminLoginPageUrlParm;
    }

    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException authException) throws IOException, ServletException {
        boolean isAjax = RequestUtil.isAjax(request);
        boolean hasSession = SystemHelper.isAuthenticated();
        if (isAjax && !hasSession) {
            this.transformAjaxRequest(request, response);
        } else {
            String targetUrl = null;
            String url = request.getRequestURI();
            if (url.indexOf("admin") != -1) {
                // 未登录而访问后台受控资源时，跳转到后台登录页面
                targetUrl = adminLoginPageUrl;
            } else {
                // 未登录而访问前台受控资源时，跳转到前台登录页面
                targetUrl = foreLoginPageUrl;
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
}
