package com.example.pageserver.enums.impl;

import com.example.pageserver.enums.BaseEnum;

public enum ExceptionEnum implements BaseEnum {
    LOGIN_PARAMETER_EXCEPTION(101,"请检查您的账号密码及权限是否正确！"),
    UPDATE_PARAMETER_EXCEPTION(102,"信息更新失败！"),
    SELECT_PARAMETER_EXCEPTION(107,"参数异常！"),
    GET_IMAGE_EXCEPTION(103,"图片没有找到,请联系管理员！"),
    FILE_DOWNLOAD_EXCEPTION(104,"文件下载失败！"),
    FILE_REMOVE_EXCEPTION(106,"文件删除失败！"),
    FILE_UPLOAD_EXCEPTION(105,"文件上传失败！");

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
