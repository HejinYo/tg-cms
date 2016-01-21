package com.turingoal.cms.core.web.controller.fore.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import com.turingoal.common.constants.ConstantSystemValues;

/**
 * 数据库操作相关异常处理
 */
@ControllerAdvice
public class ForeDbExceptionHandler {
    private static Logger log = LogManager.getLogger(ForeDbExceptionHandler.class);

    /**
     * DataAccessException
     */
    @ExceptionHandler(DataAccessException.class)
    public String processRuntimeException(final NativeWebRequest request, final RuntimeException e) {
        request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, "数据操作错误", WebRequest.SCOPE_REQUEST); // 存入request 异常信息
        log.error("系统异常：", e);
        // return new JsonResultBean(JsonResultBean.FAULT, "对不起，数据操作错误！");
        return "index";
    }

    /**
     * 主键重复
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String processExcessiveAttemptsException(final NativeWebRequest request, final DuplicateKeyException e) {
        request.setAttribute(ConstantSystemValues.ERROR_MESSAGE, "数据操作错误", WebRequest.SCOPE_REQUEST); // 存入request 异常信息
        log.error("系统异常：", e);
        // return new JsonResultBean(JsonResultBean.FAULT, "对不起，数据操作错误！");
        return "index";
    }
}
