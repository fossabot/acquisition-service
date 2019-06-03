package com.acquisition.util;

/**
 * @author yxk
 * @Description: http请求返回Bean
 * @create 2019/5/31
 * @since 1.0.0
 */
public class Result<T> {
    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体的内容.
     */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Result success(T object) {
        this.setCode(200);
        this.setMsg("成功");
        this.setData(object);
        return this;
    }

    public Result error(Integer code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

}
