package com.example.pageserver.exception;

import lombok.Data;

import java.text.MessageFormat;

@Data
public class BaseException extends RuntimeException{
    protected Integer code;
    protected String msg;

    public BaseException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return MessageFormat.format("异常码：{0}\n异常消息：{1}",this.code,this.msg);
    }
}
