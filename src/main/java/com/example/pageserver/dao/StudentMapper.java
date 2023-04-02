package com.example.pageserver.dao;

import com.example.pageserver.entity.Student;

public interface StudentMapper {
    Student selectBySid(Integer sid);
}
