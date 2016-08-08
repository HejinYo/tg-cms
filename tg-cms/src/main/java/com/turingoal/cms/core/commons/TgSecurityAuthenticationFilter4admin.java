package com.turingoal.cms.core.commons;

import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.turingoal.common.exception.CaptchaIncorrectException;
import com.turingoal.common.exception.CaptchaRequiredException;
import com.turingoal.common.util.math.CaptchaUtil;
import jodd.util.StringUtil;

/**
 * 登录
 */
public class TgSecurityAuthenticationFilter4admin extends UsernamePasswordAuthenticationFilter {
   public static final String SPRING_SECURITY_FORM_CAPTCHA_KEY = "tg_captchaCode";
   public static final String SPRING_SECURITY_PASSWORD_RETRY_CACHE = "secruity-passwordRetryCache";
   private String captchaParameter = SPRING_SECURITY_FORM_CAPTCHA_KEY;
   private boolean openValidateCaptchaCode = false;  // 是否开启验证码功能
   private boolean errorsLock = true;  // 是否开启验证码功能
   private int maxRetryCount = 5; // 密码最大重试次数
   @Autowired
   private CacheManager springCacheManager;

   public void setCaptchaParameter(final String captchaParameterParm) {
      this.captchaParameter = captchaParameterParm;
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

   /**
    * 认证
    */
   public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {
      Authentication authentication;
      // 开启验证码功能的情况
      if (openValidateCaptchaCode) {
         checkValidateCode(request);
      }
      // 超过错误次数锁定用户
      if (errorsLock) {
         // 根据缓存名字获取Cache
         Cache passwordRetryCache = springCacheManager.getCache(SPRING_SECURITY_PASSWORD_RETRY_CACHE);
         String username = obtainUsername(request);
         if (StringUtil.isNotBlank(username)) {
            username = username.trim();
         }
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
         authentication = super.attemptAuthentication(request, response);
         // 认证失败会在上面跳出不会执行下面的语句， 认证成功清除缓存的错误次数
         if (authentication.getPrincipal() != null) {
            passwordRetryCache.evict(username);
         }
      } else {
         authentication = super.attemptAuthentication(request, response);
      }
      return authentication;
   }

   /**
    * 校验验证码
    */
   public void checkValidateCode(final HttpServletRequest request) {
      String inputCode = this.obtainCaptcha(request);
      if (inputCode == null) {
         throw new CaptchaRequiredException("请填写验证码！");
      } else if (!CaptchaUtil.checkCaptcha(request.getSession(), inputCode)) {
         throw new CaptchaIncorrectException("验证码不正确！");
      }
   }

   /**
    * 获取request里的验证码
    */
   protected String obtainCaptcha(final HttpServletRequest request) {
      String capStr = request.getParameter(captchaParameter);
      String captchaCode = "";
      if (capStr != null) {
         captchaCode = capStr.trim().toLowerCase();
      }
      return captchaCode;
    }
}