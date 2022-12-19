package com.neuedu.config;

import com.neuedu.common.ResultJson;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 施子安
 * @create
 * 统一异常管理，aop，管理controller层切面请求，
 * 配合ExceptionHandler做全局异常处理
 */
@RestControllerAdvice
public class DefaultException {
    @ExceptionHandler
    ResultJson defaultExceptionHandler(Exception e){
        e.printStackTrace();
        return ResultJson.failed("系统异常，请联系系统管理员");
    }
}
