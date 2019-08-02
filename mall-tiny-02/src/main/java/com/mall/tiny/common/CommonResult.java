package com.mall.tiny.common;

import lombok.Data;

/**
 * @Author: yanyiheng
 * @Description: 通用返回对象
 * @Date: created in 2019/7/29 20:15
 * @Modified By:
 */
@Data
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResult() {

    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.message(), data);
    }

    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResult<T> failure(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }
}
