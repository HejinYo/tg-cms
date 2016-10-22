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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.repository.LogInfoDao;
import com.turingoal.cms.core.repository.UserDao;
import com.turingoal.common.constants.ConstantLogInfoTypes;
import com.turingoal.common.domain.form.LogInfoForm;
import com.turingoal.common.support.spring.SpringSecurityLogoutSuccessUrlResolver;

/**
 * 退出成功处理
 */
public class TgSecurityLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
    private String successUrl = "/"; // 退出成功url
    private List<SpringSecurityLogoutSuccessUrlResolver> resolvers = new ArrayList<SpringSecurityLogoutSuccessUrlResolver>();
    private final Logger log = LogManager.getLogger(TgSecurityLogoutSuccessHandler.class);
    @Autowired
    private UserCache userCache;
    @Autowired
    private UserDao userDao;
    @Autowired
    private LogInfoDao logInfoDao;

    public TgSecurityLogoutSuccessHandler() {
        super();
    }

    public TgSecurityLogoutSuccessHandler(final String defaultTargetUrl) {
        successUrl = defaultTargetUrl;
        setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        String targetUrl = successUrl;
        setDefaultTargetUrl(targetUrl);
        for (SpringSecurityLogoutSuccessUrlResolver resolver : resolvers) {
            if (resolver.support(authentication)) {
                targetUrl = resolver.resolve();
                setDefaultTargetUrl(targetUrl);
            }
        }
        // 保持用户退出信息
        saveLogoutInfo(request, authentication);
        // 清除缓存
        userCache.removeUserFromCache(authentication.getName());
        super.onLogoutSuccess(request, response, authentication);
    }

    /**
     * 保存用户登录信息
     */
    private void saveLogoutInfo(final HttpServletRequest httpServletRequest, final Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        // 修改用户退出信息
        try {
            UserForm userForm = new UserForm();
            userForm.setId(user.getId());
            userForm.setLastLogoutTime(new Date());
            userDao.updateUserLogoutInfo(userForm);
            // 保存退出日志信息
            userForm.setUsername(user.getUsername());
            userForm.setLastLoginTime(new Date()); // 最后登录时间
            String ip = SystemHelper.getCurrentUserIp();
            userForm.setLastLoginIp(ip); // 最后登录ip
            userForm.setLastLoginLoc(SystemHelper.getCurrentUserRegion(ip)); // 最后登录地点
            userForm.setLastLoginClientType("web"); // 最后登录客户端类型
            userForm.setLastLoginClientDesc(httpServletRequest.getHeader("User-Agent")); // 最后登录客户端详情
            LogInfoForm loginForm = new LogInfoForm(userForm.getId(), userForm.getUsername(), userForm.getLastLoginIp(), userForm.getLastLoginLoc(), userForm.getLastLoginClientType(), userForm.getLastLoginClientDesc());
            loginForm.setLogType(ConstantLogInfoTypes.LOGOUT_LOG);
            loginForm.setMessage("用户" + user.getUsername() + "[退出]系统【成功】！");
            loginForm.setSuccess(1);
            logInfoDao.add(loginForm);
        } catch (DataAccessException e) {
            if (log.isWarnEnabled()) {
                log.info("无法更新用户登录信息至数据库");
            }
        }
    }

    public void setResolvers(final List<SpringSecurityLogoutSuccessUrlResolver> resolversParm) {
        this.resolvers = resolversParm;
    }
}
