package com.acquisition.util;



/**
 * @Description: 返回模板
 *
 * @author yuxk
 * @create 2019/5/30
 * @since 1.0.0
 */
public class Result {

    private int code;
    private String msg;
    private String data;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认的成功
     *
     * @return
     */
    public Result success() {
        return new Result(Status.SUCCESS.Code, Status.SUCCESS.Msg);
    }

    /**
     * 默认的失败
     *
     * @return
     */
    public Result error() {
        return new Result(Status.FAIL.Code, Status.FAIL.Msg);
    }

    /**
     * 成功 + 返回的成功信息
     *
     * @param data
     * @return
     */
    public Result sussess(String data) {
        return new Result(Status.SUCCESS.Code, Status.SUCCESS.Msg, data);
    }

    public enum Status {

        SUCCESS(0, "成功"),

        FAIL(1, "失败");

        private int Code;
        private String Msg;

        Status(int code, String msg) {
            this.Code = code;
            this.Msg = msg;
        }
    }

}
