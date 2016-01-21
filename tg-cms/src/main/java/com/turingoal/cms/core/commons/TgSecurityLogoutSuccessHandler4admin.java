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
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.core.domain.form.UserForm;
import com.turingoal.cms.core.repository.UserDao;

/**
 * 这个类主要处理退出后的处理，退出后修改用户退出信息
 */
public class TgSecurityLogoutSuccessHandler4admin extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler, InitializingBean {
    private final Logger log = LogManager.getLogger(TgSecurityLogoutSuccessHandler4admin.class);
    @Autowired
    private UserCache userCache;
    @Autowired
    private UserDao userDao;

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication) throws IOException, ServletException {
        SystemLogHelper.loginLog(authentication.getName(), "用户[退出]系统【成功】！"); // 退出成功日志
        String refererUrl = request.getHeader("Referer");
        log.debug("退出系统！" + refererUrl);
        // 保持用户退出信息
        saveLogoutInfo(request, authentication);
        // 清除缓存
        userCache.removeUserFromCache(authentication.getName());
        super.onLogoutSuccess(request, response, authentication);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("afterPropertiesSet");
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
        } catch (DataAccessException e) {
            if (log.isWarnEnabled()) {
                log.info("无法更新用户登录信息至数据库");
            }
        }
    }
}
