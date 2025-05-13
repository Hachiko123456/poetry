package com.wechatapp.mengyao.poetry.core;

/**
 * @author yanghuaxu
 * @date 2025/5/11 20:53
 */
public enum ExceptionCode {

    PARAMS_EXCEPTION(400001, "参数异常"),
    DATABASE_EXCEPTION(400002, "数据库操作异常");

    private int exceptionCode;

    private String exceptionName;

    ExceptionCode(int exceptionCode, String exceptionName) {
        this.exceptionCode = exceptionCode;
        this.exceptionName = exceptionName;
    }

    public int getExceptionCode() {
        return exceptionCode;
    }

    public String getExceptionName() {
        return exceptionName;
    }
}
