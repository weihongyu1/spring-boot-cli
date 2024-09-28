package com.why.springbootcli.common.enums;

/**
 * 响应枚举
 *
 * @DATE 2024/9/28
 * @Author why
 */
public enum ResponseEnum {

    SUCCESS(200, "success"),
    FAIL(500, "error");

    private final Integer code;
    private final String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
