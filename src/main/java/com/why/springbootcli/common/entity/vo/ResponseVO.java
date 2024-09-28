package com.why.springbootcli.common.entity.vo;

import com.why.springbootcli.common.enums.ResponseEnum;
import lombok.Data;

/**
 * 统一数据返回
 *
 * @DATE 2024/9/28
 * @Author why
 */
@Data
public class ResponseVO<T> {

    private Integer code;
    private String msg;
    private T data;

    public ResponseVO() {};

    public ResponseVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> success() {
        return new ResponseVO<T>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), null);
    }

    /**
     * 成功
     * @param msg 消息
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> success(String msg) {
        return new ResponseVO<T>(ResponseEnum.SUCCESS.getCode(), msg, null);
    }

    /**
     * 成功
     * @param code 状态码
     * @param msg 消息
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> success(Integer code, String msg) {
        return new ResponseVO<T>(code, msg, null);
    }

    /**
     * 成功
     * @param data 数据
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> success(T data) {
        return new ResponseVO<T>(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 成功
     * @param code 状态码
     * @param msg 消息
     * @param data 数据
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> success(Integer code, String msg, T data) {
        return new ResponseVO<T>(code, msg, data);
    }

    /**
     * 失败
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> fail() {
        return new ResponseVO<T>(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(), null);
    }

    /**
     * 失败
     * @param msg 消息
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> fail(String msg) {
        return new ResponseVO<T>(ResponseEnum.FAIL.getCode(), msg, null);
    }

    /**
     * 失败
     * @param code 状态码
     * @param msg 消息
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> fail(Integer code, String msg) {
        return new ResponseVO<T>(code, msg, null);
    }

    /**
     * 失败
     * @param data 数据
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> fail(T data) {
        return new ResponseVO<T>(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMsg(), data);
    }

    /**
     * 失败
     * @param code 状态码
     * @param msg 消息
     * @param data 数据
     * @return 响应信息
     * @param <T> 泛型
     */
    public static <T> ResponseVO<T> fail(Integer code, String msg, T data) {
        return new ResponseVO<T>(code, msg, data);
    }
}
