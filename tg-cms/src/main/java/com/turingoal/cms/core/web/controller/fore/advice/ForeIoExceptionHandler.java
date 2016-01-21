package com.turingoal.cms.core.web.controller.fore.advice;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * IO相关异常处理
 */
@ControllerAdvice
public class ForeIoExceptionHandler {
    private static Logger log = LogManager.getLogger(ForeIoExceptionHandler.class);

    /**
     * IO异常
     */
    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
    public String handleIOException() {
        log.error("IO发生异常");
        // return new JsonResultBean(JsonResultBean.FAULT, "系统错误，请联系管理员！");
        return "index";
    }
}
