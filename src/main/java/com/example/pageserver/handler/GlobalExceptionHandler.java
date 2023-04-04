package com.example.pageserver.handler;

import com.example.pageserver.exception.children.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String exceptionHandler(MyException e){
        System.out.println(e.getMsg());
        return e.getMsg();
    }
}
