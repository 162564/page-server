package com.example.pageserver.mapper;

import com.example.pageserver.entity.Company;
import com.example.pageserver.entity.Student;

import java.util.List;

public interface StudentMapper {
    Student selectByInfo(String username,String password);
    Student selectResumeBySid(Integer sid);
    int checkInfo(String username,String password);
    int updateInfo(Student student);
    int uploadResume(Student student);
    Student downloadInfo(Integer sid);
    int removeResume(Student student);
    String selectNotice(Integer sid);
    Student selectBySid(Integer sid);
    int updateState(Student student);
    List<Student> selectAll();
    int selectUnderemployed();
    int selectEmployment();
}
