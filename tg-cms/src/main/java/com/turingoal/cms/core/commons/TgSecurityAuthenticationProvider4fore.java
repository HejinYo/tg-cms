package com.turingoal.cms.core.commons;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.turingoal.cms.core.domain.User;
import com.turingoal.common.util.spring.SpringSecurityAbstractUserDetailsAuthenticationProvider;
import com.turingoal.common.util.spring.SpringSecurityPasswordHelper;
import jodd.util.StringUtil;

/**
 * 前台前台用户凭证
 */
public class TgSecurityAuthenticationProvider4fore extends SpringSecurityAbstractUserDetailsAuthenticationProvider {
    public static final String SPRING_SECURITY_FORM_CAPTCHA_KEY = "tg_captchaCode";
    public static final String SPRING_SECURITY_PASSWORD_RETRY_CACHE = "secruity-passwordRetryCache";
    private boolean openValidateCaptchaCode = false; // 是否开启验证码功能
    private boolean errorsLock = true; // 是否开启验证码功能
    private int maxRetryCount = 5; // 密码最大重试次数
    private UserCache userCache;
    private UserDetailsService userDetailsService;
    @Autowired
    private CacheManager springCacheManager;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        TgSecurityAuthenticationToken4fore authenticationToken = (TgSecurityAuthenticationToken4fore) authentication;
        Authentication auth;
        // 开启验证码功能的情况
        if (openValidateCaptchaCode) {
            SystemHelper.checkValidateCode(authenticationToken.getCaptcha());
        }
        // 超过错误次数锁定用户
        if (errorsLock) {
            // 根据缓存名字获取Cache
            Cache passwordRetryCache = springCacheManager.getCache(SPRING_SECURITY_PASSWORD_RETRY_CACHE);
            // 获取用户名
            String username = authenticationToken.getName().trim();
            // 缓存里的错误次数
            AtomicInteger retryCount = passwordRetryCache.get(username, AtomicInteger.class);
            if (retryCount == null) {
                retryCount = new AtomicInteger(0);
                passwordRetryCache.put(username, retryCount);
            }
            int count = retryCount.incrementAndGet();
            if (count > maxRetryCount) { // 是否超过最大次数
                SystemLogHelper.loginLog(username, "用户登录失败超过最大次数，账户锁定！");
                throw new LockedException("用户登录失败超过最大次数，用户已锁定！");
            }
            auth = authenticateUser(authentication);
            if (auth != null) {
                // 认证成功清除缓存的错误次数
                if (authentication.getPrincipal() != null) {
                    passwordRetryCache.evict(username);
                }
            }
        } else {
            auth = authenticateUser(authenticationToken);
        }
        return auth;
    }

    /**
     * 认证用户
     */
    public Authentication authenticateUser(final Authentication authentication) {
        String username = authentication.getName().trim(); // 用户名
        boolean cacheWasUsed = true; // 是否在缓存中
        UserDetails user = this.userCache.getUserFromCache(username);
        // 缓存中不存在用户
        if (user == null) {
            cacheWasUsed = false;
            try {
                // 获取用户
                user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
            } catch (UsernameNotFoundException notFound) {
                if (isHideUserNotFoundExceptions()) {
                    throw new BadCredentialsException(getMessagesSource().getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "认证失败"));
                } else {
                    throw notFound;
                }
            }
        }
        try {
            checkUserDomain(user); // 检查用户所属域
            getPreAuthenticationChecks().check(user); // 前置检查
            checkPassword(authentication, user); // 验证密码
        } catch (AuthenticationException exception) {
            if (cacheWasUsed) {
                cacheWasUsed = false;
                user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
                checkUserDomain(user); // 检查用户所属域
                getPreAuthenticationChecks().check(user); // 前置检查
                checkPassword(authentication, user); // 验证密码
            } else {
                throw exception;
            }
        }
        getPostAuthenticationChecks().check(user); // 后置检查
        if (!cacheWasUsed) {
            this.userCache.putUserInCache(user);
        }
        return createSuccessAuthentication(authentication, user);
    }

    /**
     * 检查用户所属域
     */
    private void checkUserDomain(final UserDetails userDetail) {
        User user = (User) userDetail;
        String userDomain = user.getDomain(); // 用户所属域
        // 不为空或不等于fore抛出异常
        if (StringUtil.isBlank(userDomain) || "default".equals(userDomain)) {
            user.setDomain("fore"); // 前台用户
        } else {
            if (isHideUserNotFoundExceptions()) {
                throw new BadCredentialsException(getMessagesSource().getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "认证失败"));
            } else {
                throw new UsernameNotFoundException("用户不存在!");
            }
        }
    }

    /**
     * 检查密码
     */
    private void checkPassword(final Authentication authentication, final UserDetails user) {
        // 验证密码
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException(getMessagesSource().getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "认证失败！"));
        }
        String presentedPassword = authentication.getCredentials().toString();
        boolean isPasswordValid = SpringSecurityPasswordHelper.isPasswordValid(user.getPassword(), presentedPassword);
        if (!isPasswordValid) {
            throw new BadCredentialsException(getMessagesSource().getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "认证失败！"));
        }
    }

    /**
     * 创建登录成功的Authentication,必须使用对应的类型
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TgSecurityAuthenticationToken4fore createSuccessAuthentication(final Authentication authentication, final UserDetails user) {
        Object principalToReturn = user;
        // 是否只保存用户名
        if (isForcePrincipalAsString()) {
            principalToReturn = user.getUsername();
        }
        List c = (List) user.getAuthorities(); // 添加默认的角色
        c.addAll(authentication.getAuthorities());
        TgSecurityAuthenticationToken4fore result = new TgSecurityAuthenticationToken4fore(principalToReturn, authentication.getCredentials(), user.getAuthorities());
        result.setDetails(authentication.getDetails());
        return result;
    }

    /**
     * 获取UserDetails
     */
    protected final UserDetails retrieveUser(final String username, final Authentication authentication) throws AuthenticationException {
        UserDetails loadedUser;
        try {
            loadedUser = userDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException notFound) {
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return TgSecurityAuthenticationToken4fore.class.isAssignableFrom(authentication);
    }

    public void setUserCache(final UserCache userCacheParm) {
        this.userCache = userCacheParm;
    }

    public void setUserDetailsService(final UserDetailsService userDetailsServiceParm) {
        this.userDetailsService = userDetailsServiceParm;
    }

    public void setOpenValidateCaptchaCode(final boolean openValidateCaptchaCodeParm) {
        this.openValidateCaptchaCode = openValidateCaptchaCodeParm;
    }

    public void setMaxRetryCount(final int maxRetryCountParm) {
        this.maxRetryCount = maxRetryCountParm;
    }

    public void setErrorsLock(final boolean errorsLockParm) {
        this.errorsLock = errorsLockParm;
    }
}