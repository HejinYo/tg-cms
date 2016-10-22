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
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import com.turingoal.cms.core.domain.User;
import com.turingoal.common.domain.form.LogInfoForm;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.repository.LogInfoDao;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.common.constants.ConstantLogInfoTypes;
import com.turingoal.common.support.spring.SpringSecurityDirectUrlResolver;
import jodd.util.StringUtil;

/**
 * 这个类主要处理登录后的处理，在登录成功后修改用户登录信息
 */
public class TgSecurityLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements InitializingBean {
    private final Logger log = LogManager.getLogger(TgSecurityLoginSuccessHandler.class);
    private String successUrl = "/"; // 登录成功url
    private boolean forwardToDestination = false; // forward方式跳转
    private List<SpringSecurityDirectUrlResolver> directUrlResolvers = new ArrayList<SpringSecurityDirectUrlResolver>(); // 多登录页面处理
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogInfoDao logInfoDao;

    public TgSecurityLoginSuccessHandler() {
        super();
    }

    public TgSecurityLoginSuccessHandler(final String defaultTargetUrl) {
        successUrl = defaultTargetUrl;
        setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Authentication authentication) throws IOException, ServletException {
        // 多登录页面处理
        String targetUrl = successUrl; // 每次恢复为默认的
        setDefaultTargetUrl(targetUrl);
        for (SpringSecurityDirectUrlResolver resolver : directUrlResolvers) {
            if (resolver.support(httpServletRequest)) {
                targetUrl = resolver.directUrl();
                setDefaultTargetUrl(targetUrl);
            }
        }
        targetUrl = determineTargetUrl(httpServletRequest, httpServletResponse);
        // 保存用户登录信息
        saveLoginInfo(httpServletRequest, authentication);
        if (this.forwardToDestination) {
            log.debug("登录成功，Forwarding 到页面 " + targetUrl);
            httpServletRequest.getRequestDispatcher(targetUrl).forward(httpServletRequest, httpServletResponse);
        } else {
            log.debug("登录成功，Redirecting 到页面 " + targetUrl);
            // 在redirectStrategy中，'/'代表的是项目根目录而不是服务器根目录。
            super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);
        }
    }

    /**
     * 保存用户登录信息
     */
    private void saveLoginInfo(final HttpServletRequest httpServletRequest, final Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        // 修改用户登录信息
        try {
            UserForm userForm = new UserForm();
            userForm.setId(user.getId());
            userForm.setUsername(user.getUsername());
            userForm.setLastLoginTime(new Date()); // 最后登录时间
            String ip = SystemHelper.getCurrentUserIp();
            userForm.setLastLoginIp(ip); // 最后登录ip
            userForm.setLastLoginLoc(SystemHelper.getCurrentUserRegion(ip)); // 最后登录地点
            userForm.setLastLoginClientType("web"); // 最后登录客户端类型
            userForm.setLastLoginClientDesc(httpServletRequest.getHeader("User-Agent")); // 最后登录客户端详情
            userDao.updateUserLoginInfo(userForm);
            // 保存登录日志信息
            LogInfoForm loginForm = new LogInfoForm(userForm.getId(), userForm.getUsername(), userForm.getLastLoginIp(), userForm.getLastLoginLoc(), userForm.getLastLoginClientType(), userForm.getLastLoginClientDesc());
            loginForm.setLogType(ConstantLogInfoTypes.LOGIN_LOG);
            loginForm.setMessage("用户" + user.getUsername() + "[登录]系统【成功】！");
            loginForm.setSuccess(1);
            logInfoDao.add(loginForm);
        } catch (DataAccessException e) {
            if (log.isWarnEnabled()) {
                log.info("无法更新用户登录信息至数据库");
            }
        }
    }

    public void setForwardToDestination(final boolean forwardToDestinationParm) {
        this.forwardToDestination = forwardToDestinationParm;
    }

    public void setDirectUrlResolvers(final List<SpringSecurityDirectUrlResolver> directUrlResolversParm) {
        this.directUrlResolvers = directUrlResolversParm;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtil.isBlank(getDefaultTargetUrl())) {
            throw new Exception("没有配置defaultTargetUrl");
        }
    }
}
