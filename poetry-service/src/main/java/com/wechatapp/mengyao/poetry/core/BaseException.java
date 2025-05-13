package com.wechatapp.mengyao.poetry.core;

/**
 * @author yanghuaxu
 * @date 2025/5/11 20:52
 */
public class BaseException extends RuntimeException {
    private int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}