package com.turingoal.cms.core.web.controller.admin.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import com.turingoal.common.bean.JsonResultBean;
import com.turingoal.common.constants.ConstantSystemValues;

/**
 * DefaultExceptionHandler
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    private static Logger log = LogManager.getLogger(DefaultExceptionHandler.class);

    /**
     * 运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResultBean processRuntimeException(final NativeWebRequest request, final RuntimeException e) {
        request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, "运行中异常", WebRequest.SCOPE_REQUEST); // 存入request 异常信息
        log.error("系统异常：", e);
        return new JsonResultBean(JsonResultBean.FAULT, "系统错误，请联系管理员！");
    }

    /**
     * 出错次数太多
     */
    // @ExceptionHandler(ExcessiveAttemptsException.class)
    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // @ResponseBody
    // public JsonResultBean processExcessiveAttemptsException(final NativeWebRequest request, final ExcessiveAttemptsException e) {
    // request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, "对不起，没有认证", WebRequest.SCOPE_REQUEST); // 存入request 异常信息
    // log.error("系统异常：", e);
    // return new JsonResultBean(JsonResultBean.FAULT, "对不起，您的出错次数太多，请稍后再试！");
    // }

    /**
     * 没有认证 UnauthenticatedException @ResponseStatus 返回制定的状态码
     */
    // @ExceptionHandler(UnauthenticatedException.class)
    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // @ResponseBody
    // public JsonResultBean processUnauthenticatedException(final NativeWebRequest request, final UnauthenticatedException e) {
    // request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, "对不起，没有认证", WebRequest.SCOPE_REQUEST); // 存入request 异常信息
    // log.error("系统异常：", e);
    // return new JsonResultBean(JsonResultBean.FAULT, "对不起，您还没有登录！");
    // }

    /**
     * 没有权限 UnauthorizedException
     */
    // @ExceptionHandler({ UnauthorizedException.class })
    // @ResponseStatus(HttpStatus.UNAUTHORIZED)
    // @ResponseBody
    // public JsonResultBean processUnauthentizatedException(final NativeWebRequest request, final UnauthorizedException e) {
    // request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, "对不起，没有授权", WebRequest.SCOPE_REQUEST); // 存入request 异常信息
    // log.error("系系统异常：", e);
    // return new JsonResultBean(JsonResultBean.FAULT, "对不起，您没有该操作权限！");
    // }
}
