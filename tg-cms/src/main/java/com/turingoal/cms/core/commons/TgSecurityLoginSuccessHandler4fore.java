package com.turingoal.cms.core.commons;

import java.io.IOException;
import java.util.Date;
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
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.common.util.net.IPUtil;
import jodd.util.StringUtil;

/**
 * 这个类主要处理登录后的处理，在登录成功后修改用户登录信息
 */
public class TgSecurityLoginSuccessHandler4fore extends SimpleUrlAuthenticationSuccessHandler implements InitializingBean {
    private final Logger log = LogManager.getLogger(TgSecurityLoginSuccessHandler4fore.class);
    private boolean forwardToDestination = false; // forward方式跳转

    public void setForwardToDestination(final boolean forwardToDestinationParm) {
        this.forwardToDestination = forwardToDestinationParm;
    }

    @Autowired
    private UserDao userDao;

    @Override
    public void onAuthenticationSuccess(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse, final Authentication authentication) throws IOException, ServletException {
        SystemLogHelper.loginLog(authentication.getName(), "用户[登录]系统【成功】！"); // 登录成功日志
        String targetUrl = determineTargetUrl(httpServletRequest, httpServletResponse);
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
        SystemHelper.setCurrentUser(user); // 保存当前用户信息到session
        // 修改用户登录信息
        try {
            UserForm userForm = new UserForm();
            userForm.setId(user.getId());
            userForm.setLastLoginTime(new Date()); // 修改时间
            userForm.setLastLoginIp(IPUtil.getIpAddr(httpServletRequest));
            userDao.updateUserLoginInfo(userForm);
        } catch (DataAccessException e) {
            if (log.isWarnEnabled()) {
                log.info("无法更新用户登录信息至数据库");
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (StringUtil.isBlank(getDefaultTargetUrl())) {
            throw new Exception("没有配置defaultTargetUrl");
        }
    }
}
