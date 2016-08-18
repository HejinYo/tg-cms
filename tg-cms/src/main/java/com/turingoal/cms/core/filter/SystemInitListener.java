package com.turingoal.cms.core.filter;

import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.ServletContextAware;
import com.turingoal.common.license.TgLicenseChcker;

/**
 * 系统初始化监听器
 */
public class SystemInitListener implements ApplicationListener<ContextRefreshedEvent>, ServletContextAware {
    private final Logger log = LoggerFactory.getLogger(SystemInitListener.class);
    private ServletContext application;
    @Value("#{applicationProperties['security.openValidateCaptchaCode']}")
    private Boolean openValidateCaptchaCode; // 是否开启验证码
    @Value("#{applicationProperties['security.openValidateCaptchaCode4admin']}")
    private Boolean openValidateCaptchaCode4admin; // 后台是否开启验证码

    /**
     * 在Spring容器所有的Bean都初始化完成之后执行
     */
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        // 在web 项目中（spring mvc），系统会存在两个容器，一个是root application context ,另一个就是我们自己的 context（作为root application context的子容器）。 这种情况下，就会造成onApplicationEvent方法被执行两次。为了避免上面提到的问题，我们可以只在root application context初始化完成后调用逻辑代码，其他的容器的初始化完成，则不做任何处理
        if (event.getApplicationContext().getParent() == null) {
            log.info("系统启动");
            // 校验license
            TgLicenseChcker.checkInit(application, SystemInitListener.class);
            // 是否开启验证码
            application.setAttribute("openValidateCaptchaCode", openValidateCaptchaCode);
            // 后台是否开启验证码
            application.setAttribute("openValidateCaptchaCode4admin", openValidateCaptchaCode4admin);
        }
    }

    @Override
    public void setServletContext(final ServletContext servletContext) {
        this.application = servletContext;
    }
}
