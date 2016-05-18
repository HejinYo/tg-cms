package com.turingoal.cms.core.commons;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.turingoal.cms.core.domain.User;
import com.turingoal.cms.modules.base.domain.Global;
import com.turingoal.common.constants.ConstantSystemValues;

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
        HttpSession session = getSession();
        if (session != null) {
            session.invalidate();
        }
    }

    /**
     * 得到request
     */
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = null;
        if (RequestContextHolder.getRequestAttributes() != null) {
            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
        return request;
    }

    /**
     * 得到session
     */
    public static HttpSession getSession() {
        HttpSession session = null;
        HttpServletRequest request = getRequest();
        if (request != null) {
            session = request.getSession(true);
        }
        return session;
    }

    /**
     * 保存信息到session
     */
    public static void setSessionAttibute(final String key, final Object value) {
        HttpSession session = getSession();
        if (session != null) {
            session.setAttribute(key, value);
        }
    }

    /**
     * 从session获取属性
     */
    public static Object getSessionAttibute(final String key) {
        Object resutlt = null;
        HttpSession session = getSession();
        if (session != null) {
            resutlt = session.getAttribute(key);
        }
        return resutlt;
    }

    /**
     * 获取getCreationTime
     */
    public static long getCreationTime() {
        Long resutlt = 0L;
        HttpSession session = getSession();
        if (session != null) {
            resutlt = session.getCreationTime();
        }
        return resutlt;
    }

    /**
     * 获取getLastAccessedTime
     */
    public static long getLastAccessedTime() {
        Long resutlt = 0L;
        HttpSession session = getSession();
        if (session != null) {
            resutlt = session.getLastAccessedTime();
        }
        return resutlt;
    }

    /**
     * 检查用户是已认证
     */
    public static boolean isAuthenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
            return SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
        } else {
            return false;
        }
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
     * 获得认证信息
     */
    public static Authentication getAuthentication() {
        Authentication authentication = null;
        SecurityContextImpl securityContextImpl = (SecurityContextImpl) getSessionAttibute("SPRING_SECURITY_CONTEXT");
        if (securityContextImpl != null) {
            authentication = securityContextImpl.getAuthentication();
        }
        return authentication;
    }

    /**
     * 检查Permission
     */
    public static boolean checkPermission(final String permission) {
        boolean result = false;
        // 判断是否超级管理员
        if (isAdmin()) {
            result = true;
        } else {
            List<String> userPermissions = getCurrentUser().getUserPermissions();
            if (userPermissions != null) {
                result = userPermissions.contains(permission);
            }
        }
        return result;
    }

    /**
     * 是否超级管理员
     */
    public static boolean isAdmin() {
        return ConstantSystemValues.ADMIN_USER.equals(getCurrentUsername());
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
     * 得到当前用户IP
     */
    public static String getCurrentUserIp() {
        String currentUserIp = "";
        HttpServletRequest request = getRequest();
        if (request != null) {
            currentUserIp = request.getRemoteAddr();
        }
        return currentUserIp;
    }

    /**
     * 得到当前SessionId
     */
    public static String getCurrentSessionId() {
        String currentSessionId = "";
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            WebAuthenticationDetails details = (WebAuthenticationDetails) authentication.getDetails();
            currentSessionId = details.getSessionId();
        }
        return currentSessionId;
    }

    /**
     * 得到当前获得当前用户所拥有的权限
     */
    @SuppressWarnings("unchecked")
    public static List<GrantedAuthority> getCurrentUserAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            authorities = (List<GrantedAuthority>) authentication.getAuthorities();
        }
        return authorities;
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

    /**
     * 锁定系统屏幕
     */
    public static void lockScreen() {
        setSessionAttibute(ConstantSystemValues.LOGIN_LOCK, true);
    }

    /**
     * 检查是否锁定系统
     */
    public static boolean checkLockScreen() {
        boolean flag = false;
        if (getSessionAttibute(ConstantSystemValues.LOGIN_LOCK) != null) {
            if ((Boolean) getSessionAttibute(ConstantSystemValues.LOGIN_LOCK)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 解锁系统屏幕
     */
    public static boolean unlockScreen(final String userPass) {
        boolean flag = false;
        flag = TgSecurityPasswordHelper.isPasswordValid(getCurrentUser().getPassword(), userPass);
        if (flag) {
            setSessionAttibute(ConstantSystemValues.LOGIN_LOCK, false);
        }
        return flag;
    }
}
