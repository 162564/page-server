package com.example.pageserver.controller;

import com.example.pageserver.entity.School;
import com.example.pageserver.entity.Student;
import com.example.pageserver.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    StudentService studentService;

    @GetMapping("/select")
    public Student selectBySid(Integer sid){
        return studentService.selectBySid(sid);
    }
}
