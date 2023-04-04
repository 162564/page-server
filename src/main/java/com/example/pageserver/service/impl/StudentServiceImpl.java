package com.example.pageserver.service.impl;

import com.example.pageserver.mapper.StudentMapper;
import com.example.pageserver.entity.Student;
import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.children.MyException;
import com.example.pageserver.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    StudentMapper studentMapper;
    @Override
    public Student selectBySid(Integer sid) {
        return studentMapper.selectBySid(sid);
    }

    @Override
    public Student checkInfo(String username, String password) {
        Student student = studentMapper.checkInfo(username,password);
        if (student == null) {
            throw new MyException(ExceptionEnum.LOGIN_PARAMETER_EXCEPTION);
        }
        return student;
    }
}
