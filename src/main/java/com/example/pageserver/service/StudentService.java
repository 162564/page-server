package com.example.pageserver.service;

import com.example.pageserver.entity.Student;

public interface StudentService {
    Student selectBySid(Integer sid);
}