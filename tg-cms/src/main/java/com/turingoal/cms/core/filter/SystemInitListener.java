package com.turingoal.cms.core.filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统初始化监听器
 */
public class SystemInitListener implements ServletContextListener {
    private final Logger log = LoggerFactory.getLogger(SystemInitListener.class);

    /**
     * 初始化
     */
    @Override
    public final void contextInitialized(final ServletContextEvent sce) {
        log.info("系统启动");
        // ServletContext application = sce.getServletContext();
    }

    /**
     * 销毁
     */
    @Override
    public final void contextDestroyed(final ServletContextEvent sce) {
        log.info("系统停止");
    }
}
