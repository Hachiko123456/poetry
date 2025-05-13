package com.wechatapp.mengyao.poetry.core;

/**
 * @author yanghuaxu
 * @date 2025/5/11 20:47
 */
public class RestResponse<T> {

    private int code;    // 状态码（例如 200 成功，404 未找到）
    private String msg;  // 消息（如 "操作成功"）
    private T data;      // 返回的数据

    public static <T> RestResponse<T> ok(T data) {
        RestResponse<T> result = new RestResponse<>();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> RestResponse<T> error(int code, String msg) {
        RestResponse<T> result = new RestResponse<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
