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
        String msg = e.getMsg();
        System.out.println(msg);
        return msg;
    }
}
