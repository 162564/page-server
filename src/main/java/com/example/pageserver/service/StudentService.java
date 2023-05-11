package com.example.pageserver.service;

import com.example.pageserver.entity.Student;

import java.util.List;

public interface StudentService {
    Student selectByInfo(String username,String password);
    void checkInfo(String username,String password);
    void updateInfo(Student student);
    void uploadResume(Student student);
    Student downloadInfo(Integer sid);
    void removeResume(Student student);
    String selectNotice(Integer sid);
    List<Student> selectAll();
    int selectUnderemployed();
    int selectEmployment();
}
