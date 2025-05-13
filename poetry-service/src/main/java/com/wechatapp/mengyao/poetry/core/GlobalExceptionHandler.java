package com.wechatapp.mengyao.poetry.core;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author yanghuaxu
 * @date 2025/5/11 20:52
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理自定义业务异常
    @ExceptionHandler(BaseException.class)
    public RestResponse<Void> handleBaseException(BaseException e) {
        return RestResponse.error(e.getCode(), e.getMessage());
    }

    // 处理数据库操作异常
    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResponse<Void> handleDataAccessException(DataAccessException e) {
        return RestResponse.error(ExceptionCode.DATABASE_EXCEPTION.getExceptionCode(), ExceptionCode.DATABASE_EXCEPTION.getExceptionName());
    }

    // 处理参数校验异常（@Validated 触发的校验错误）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponse<Void> handleValidationException(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .findFirst()
                .orElse("参数校验失败");
        return RestResponse.error(ExceptionCode.PARAMS_EXCEPTION.getExceptionCode(), ExceptionCode.DATABASE_EXCEPTION.getExceptionName());
    }

    // 处理其他未捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResponse<Void> handleException(Exception e) {
        return RestResponse.error(500, "系统繁忙，请稍后再试");
    }
}