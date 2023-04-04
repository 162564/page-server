package com.example.pageserver.exception.children;

import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.BaseException;

public class MyException extends BaseException {

    public MyException(ExceptionEnum studentEnum) {
        super(studentEnum.getCode(), studentEnum.getMsg());
    }
}
