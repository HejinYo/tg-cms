package com.turingoal.cms.core.commons;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import com.turingoal.cms.core.domain.Global;
import com.turingoal.cms.core.domain.User;
import com.turingoal.common.constants.ConstantSystemValues;
import com.turingoal.common.support.system.TgSystemHelper;

/**
 * 系统帮助工具类
 */
public final class SystemHelper {

    private SystemHelper() {
        throw new Error("工具类不能实例化！");
    }

    /**
     * 退出系统并清空session
     */
    public static void logout() {
        TgSystemHelper.logout();
    }

    /**
     * 得到request
     */
    public static HttpServletRequest getRequest() {
        return TgSystemHelper.getRequest();
    }

    /**
     * 得到session
     */
    public static HttpSession getSession() {
        return TgSystemHelper.getSession();
    }

    /**
     * 保存信息到session
     */
    public static void setSessionAttibute(final String key, final Object value) {
        TgSystemHelper.setSessionAttibute(key, value);
    }

    /**
     * 从session获取属性
     */
    public static Object getSessionAttibute(final String key) {
        return TgSystemHelper.getSessionAttibute(key);
    }

    /**
     * 获取session创建时间
     */
    public static Date getSessionCreationTime() {
        return TgSystemHelper.getSessionCreationTime();
    }

    /**
     * 获取session最后访问时间
     */
    public static Date getSessionLastAccessedTime() {
        return TgSystemHelper.getSessionLastAccessedTime();
    }

    /**
     * 检查用户是已认证
     */
    public static boolean isAuthenticated() {
        return TgSystemHelper.isAuthenticated();
    }

    /**
     * 获得认证信息
     */
    public static Authentication getAuthentication() {
        return TgSystemHelper.getAuthentication();
    }

    /**
     * 是否超级管理员
     */
    public static boolean isAdmin() {
        return TgSystemHelper.isAdmin(getCurrentUsername());
    }

    /**
     * 得到当前用户IP
     */
    public static String getCurrentUserIp() {
        return TgSystemHelper.getCurrentUserIp();
    }

    /**
     * 得到当前用户IP对应的地址
     */
    public static String getCurrentUserRegion(final String ip) {
        return TgSystemHelper.getCurrentUserRegion(ip);
    }

    /**
     * 得到当前SessionId
     */
    public static String getCurrentSessionId() {
        return TgSystemHelper.getCurrentSessionId();
    }

    /**
     * 得到当前获得当前用户所拥有的权限
     */
    public static List<GrantedAuthority> getCurrentUserAuthorities() {
        return TgSystemHelper.getCurrentUserAuthorities();
    }

    /**
     * 检查Permission
     */
    public static boolean checkPermission(final String permission) {
        return TgSystemHelper.checkPermission(getCurrentUsername(), getCurrentUser().getUserPermissions(), permission);
    }

    /**
     * 锁定系统屏幕
     */
    public static void lockScreen() {
        TgSystemHelper.lockScreen();
    }

    /**
     * 检查是否锁定系统
     */
    public static boolean checkLockScreen() {
        return TgSystemHelper.checkLockScreen();
    }

    /**
     * 解锁系统屏幕
     */
    public static boolean unlockScreen(final String userPass) {
        return TgSystemHelper.unlockScreen(getCurrentUser().getPassword(), userPass);
    }

    /**
     * 校验验证码
     */
    public static void checkValidateCode(final String captchaStr) {
        TgSystemHelper.checkValidateCode(captchaStr);
    }

    /**
     * 得到当前用户
     */
    public static User getCurrentUser() {
        User user = (User) getSessionAttibute(ConstantSystemValues.CURRENT_USER);
        if (user == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
                user = (User) auth.getPrincipal();
            }
        }
        return user;
    }

    /**
     * 保存当前用户
     */
    public static void setCurrentUser(final User user) {
        setSessionAttibute(ConstantSystemValues.CURRENT_USER, user);
    }

    /**
     * 得到当前用户id
     */
    public static String getCurrentUserId() {
        String userId = null;
        User user = getCurrentUser();
        if (user != null) {
            userId = user.getId();
        }
        return userId;
    }

    /**
     * 得到当前用户用户名
     */
    public static String getCurrentUsername() {
        String username = null;
        User user = getCurrentUser();
        if (user != null) {
            username = user.getUsername();
        }
        return username;
    }

    /**
     * 得到当前用户真实姓名
     */
    public static String getCurrentUserRealname() {
        String userRealname = null;
        User user = getCurrentUser();
        if (user != null) {
            userRealname = user.getRealname();
        }
        return userRealname;
    }

    /**
     * 设置全局配置
     */
    public static void setGlobal(final Global global) {
        setSessionAttibute("global", global);
    }

    /**
     * 得到全局配置
     */
    public static Global getGlobal() {
        Global resutlt = null;
        HttpSession session = getSession();
        if (session != null) {
            resutlt = (Global) session.getAttribute("global");
        }
        return resutlt;
    }
}
