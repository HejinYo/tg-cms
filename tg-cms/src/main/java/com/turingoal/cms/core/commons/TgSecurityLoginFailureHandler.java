package com.turingoal.cms.core.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import com.turingoal.cms.core.domain.form.LogInfoForm;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.repository.LogInfoDao;
import com.turingoal.common.constants.ConstantLogInfoTypes;
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
    @Autowired
    private LogInfoDao logInfoDao;

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
        String username = request.getParameter(usernameParameter); // 用户名
        // 多登录页面处理
        String targetUrl = failureUrl; // 每次恢复成默认的
        setDefaultFailureUrl(targetUrl);
        for (SpringSecurityDirectUrlResolver resolver : directUrlResolvers) {
            if (resolver.support(request)) {
                targetUrl = resolver.directUrl();
                setDefaultFailureUrl(targetUrl);
            }
        }
        // 保存用户登录信息
        saveLoginInfo(request, username, exception);
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
     * 保存用户登录信息
     */
    private void saveLoginInfo(final HttpServletRequest httpServletRequest, final String username, final AuthenticationException exception) {
        // 修改用户登录信息
        try {
            UserForm userForm = new UserForm();
            userForm.setId(null);
            userForm.setUsername(username);
            userForm.setLastLoginTime(new Date()); // 最后登录时间
            String ip = SystemHelper.getCurrentUserIp();
            userForm.setLastLoginIp(ip); // 最后登录ip
            userForm.setLastLoginLoc(SystemHelper.getCurrentUserRegion(ip)); // 最后登录地点
            userForm.setLastLoginClientType("web"); // 最后登录客户端类型
            userForm.setLastLoginClientDesc(httpServletRequest.getHeader("User-Agent")); // 最后登录客户端详情
            // 保存登录日志信息
            LogInfoForm loginForm = new LogInfoForm(userForm);
            loginForm.setLogType(ConstantLogInfoTypes.LOGIN_LOG);
            loginForm.setException(exception.getMessage());
            loginForm.setMessage("用户" + username + "[登录]系统【失败】！");
            loginForm.setSuccess(2);
            logInfoDao.add(loginForm);
        } catch (DataAccessException e) {
            if (log.isWarnEnabled()) {
                log.info("无法更新用户登录信息至数据库");
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
