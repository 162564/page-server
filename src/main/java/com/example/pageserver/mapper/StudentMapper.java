package com.example.pageserver.mapper;

import com.example.pageserver.entity.Student;

public interface StudentMapper {
    Student selectBySid(Integer sid);
    Student checkInfo(String username,String password);
}
