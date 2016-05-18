package com.turingoal.cms.core.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.turingoal.common.util.io.PropsUtil;
import jodd.datetime.JDateTime;

/**
 * 前台拦截器
 */
public class TgMaintenanceInterceptor extends HandlerInterceptorAdapter {
    private static String propFileName = "application.properties";
    private static final boolean MAINTENANCE_ENABLED = Boolean.valueOf(PropsUtil.getValue("system.maintenanceEnabled", propFileName)); // 师父开启系统维护
    private static final String ERROR_PAGE = PropsUtil.getValue("system.maintenancePage", propFileName); // 跳转到维护
    private static final Integer START_HOUR = Integer.valueOf(PropsUtil.getValue("system.maintenanceStartHour", propFileName)); // 维护开始时间
    private static final Integer END_HOUR = Integer.valueOf(PropsUtil.getValue("system.maintenanceEndHour", propFileName)); // 维护开始时间

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        // 是否开启系统维护
        if (MAINTENANCE_ENABLED) {
            // 判断当前时间是否在维护时间范围内，如果是显示维护界面。0点到6点
            Integer currentHour = new JDateTime().getHour();
            if (START_HOUR <= currentHour && currentHour < END_HOUR) {
                response.sendRedirect(request.getContextPath() + ERROR_PAGE);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}
