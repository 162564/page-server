package com.example.pageserver.service.impl;

import com.example.pageserver.dao.StudentMapper;
import com.example.pageserver.entity.Student;
import com.example.pageserver.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;
    @Override
    public Student selectBySid(Integer sid) {
        return studentMapper.selectBySid(sid);
    }
}
