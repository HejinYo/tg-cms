package com.turingoal.cms.core.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;

import com.turingoal.common.support.spring.SpringSecurityDirectUrlResolver;

import jodd.util.StringUtil;

/**
 * 这个类主要处理登录失败后的处理，在登录失败后记录日志
 */
public class TgSecurityLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler implements InitializingBean {
    private final Logger log = LogManager.getLogger(TgSecurityLoginFailureHandler.class);
    public static final Integer AUTHENTICATION_FAILURE_CODE = 401;
    private String failureUrl; // 登录失败默认url
    private String usernameParameter = "username"; // 用户名参数
    private List<SpringSecurityDirectUrlResolver> directUrlResolvers = new ArrayList<SpringSecurityDirectUrlResolver>(); // 多登录页面处理

    public TgSecurityLoginFailureHandler() {
        super();
    }

    public TgSecurityLoginFailureHandler(final String defaultFailureUrl) {
        failureUrl = defaultFailureUrl;
        setDefaultFailureUrl(defaultFailureUrl);
    }

    /**
     * 认证失败
     */
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response, final AuthenticationException exception) throws IOException, ServletException {
        SystemLogHelper.loginLog(request.getParameter(usernameParameter), "用户[登录]系统【失败】：" + exception.getLocalizedMessage()); // 登录失败日志
        // 多登录页面处理
        String targetUrl = failureUrl; // 每次恢复成默认的
        setDefaultFailureUrl(targetUrl);
        for (SpringSecurityDirectUrlResolver resolver : directUrlResolvers) {
            if (resolver.support(request)) {
                targetUrl = resolver.directUrl();
                setDefaultFailureUrl(targetUrl);
            }
        }
        if (targetUrl == null) {
            log.debug("没有配置defaultFailureUrl, sending 401 Unauthorized error");
            response.sendError(AUTHENTICATION_FAILURE_CODE, "认证失败: " + exception.getMessage());
        } else {
            saveException(request, exception);
            if (isUseForward()) {
                log.debug("登录失败，Forwarding 到页面 " + targetUrl);
                request.getRequestDispatcher(targetUrl).forward(request, response);
            } else {
                log.debug("登录失败，Redirecting 到页面 " + targetUrl);
                getRedirectStrategy().sendRedirect(request, response, targetUrl);
            }
        }
    }

    /**
     * setUsernameParameter
     */
    public void setUsernameParameter(final String usernameParameterParm) {
        if (StringUtil.isBlank(usernameParameterParm)) {
            log.error("Username 参数不能为空");
        } else {
            this.usernameParameter = usernameParameterParm;
        }
    }

    /**
     * setFailureUrl
     */
    public void setFailureUrl(final String failureUrlParm) {
        if (UrlUtils.isValidRedirectUrl(failureUrlParm)) {
            log.error(failureUrlParm + "' 不是有效的 redirect URL");
        }
        this.failureUrl = failureUrlParm;
    }

    public void setDirectUrlResolvers(final List<SpringSecurityDirectUrlResolver> directUrlResolversParm) {
        this.directUrlResolvers = directUrlResolversParm;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
    }
}
