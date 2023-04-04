package com.example.pageserver.controller;

import com.example.pageserver.entity.Student;
import com.example.pageserver.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Resource
    StudentService studentService;

    @GetMapping("/select")
    public Student selectBySid(Integer sid){
        Student student = studentService.selectBySid(sid);
        System.out.println(student);
        return  student;
    }

    @GetMapping("/checkInfo")
    public Boolean checkInfo(String username,String password){
        studentService.checkInfo(username, password);
        return true;
    }
}
