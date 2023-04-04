package com.example.pageserver.enums.impl;

import com.example.pageserver.enums.BaseEnum;

public enum ExceptionEnum implements BaseEnum {
    LOGIN_PARAMETER_EXCEPTION(102,"请检查您的账号密码及权限是否正确！");
    private Integer code;
    private String msg;

    ExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
