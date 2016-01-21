package com.turingoal.cms.core.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import com.turingoal.common.constants.ConstantSystemValues;

/**
 * Spring 全局异常处理 .HandlerExceptionResolver是一个接口，springMVC本身已经对其有了一个自身的实现——DefaultExceptionResolver,该解析器只是对其中的一些比较典型的异常进行了拦截处理 。
 */
public class SpringExceptionHandler implements HandlerExceptionResolver {
    private static Logger log = LogManager.getLogger(SpringExceptionHandler.class);

    /**
     * 异常处理.第4个参数表示对哪种类型的异常进行处理，如果想同时对多种异常进行处理，可以把它换成一个异常数组。
     */
    public final ModelAndView resolveException(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) {
        request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, ex.toString());
        if (log.isDebugEnabled()) {
            // debug模式
            log.error("系统异常：", ex);
            ex.printStackTrace();
        } else {
            // info模式
            log.error(ex.toString());
            ex.printStackTrace();
        }
        return null;
    }
}
