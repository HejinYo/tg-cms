package com.turingoal.cms.core.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.exception.BusinessException;
import com.turingoal.common.util.io.JsonUtil;
import com.turingoal.common.util.net.WebUtils;

/**
 * Spring 全局异常处理 .自定义SimpleMappingExceptionResolver覆盖spring的SimpleMappingExceptionResolver.复写其doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)方法，通过修改该方法实现普通异常和ajax异常的处理
 */
public class TgSpringSimpleMappingExceptionHandler extends SimpleMappingExceptionResolver {

    @Override
    protected ModelAndView doResolveException(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        ResponseBody body = handlerMethod.getMethodAnnotation(ResponseBody.class);
        // 判断有没有@ResponseBody的注解没有的话调用父方法
        if (body == null) {
            return super.doResolveException(request, response, handlerMethod, ex);
        }
        ModelAndView mv = new ModelAndView();
        response.setStatus(HttpStatus.OK.value()); // 设置状态码,注意这里不能设置成500，设成500JQuery不会出错误提示 并且不会有任何反应
        if (ex instanceof BusinessException) {
            BusinessException e = (BusinessException) ex;
            String msg = e.getType() + "：<br/>" + e.getDetailMsg() + "(" + e.getSuggestionMsg() + ")";
            // 已经封装过的异常
            WebUtils.writeToBrowser(JsonUtil.object2Json(new JsonResultBean(JsonResultBean.FAULT, msg)), response);
        } else {
            // 没有封装过的异常
            WebUtils.writeToBrowser(JsonUtil.object2Json(new JsonResultBean(JsonResultBean.FAULT, "系统错误，请联系管理员！")), response);
        }
        return mv;
    }
}