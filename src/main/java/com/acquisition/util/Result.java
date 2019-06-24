package com.acquisition.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yxk
 * @Description: http请求返回Bean
 * @create 2019/5/31
 * @since 1.0.0
 */
@ApiModel(value = "Result", description = "返回类型")
@Data
public class Result<T> {
    /**
     * 错误码.
     */
    @ApiModelProperty(value = "返回状态码", name = "code")
    private Integer code;

    /**
     * 提示信息.
     */
    @ApiModelProperty(value = "提示信息", name = "msg")
    private String msg;

    /**
     * 具体的内容
     */
    @ApiModelProperty(value = "返回data", name = "data")
    private T data;


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
