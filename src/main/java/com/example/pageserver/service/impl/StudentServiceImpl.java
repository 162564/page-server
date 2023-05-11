package com.example.pageserver.service.impl;

import com.example.pageserver.mapper.StudentMapper;
import com.example.pageserver.entity.Student;
import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.children.MyException;
import com.example.pageserver.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Resource
    StudentMapper studentMapper;
    @Override
    public Student selectByInfo(String username,String password) {
        return studentMapper.selectByInfo(username,password);
    }

    @Override
    public void checkInfo(String username, String password) {
        int num = studentMapper.checkInfo(username,password);
        if (num == 0) {
            throw new MyException(ExceptionEnum.LOGIN_PARAMETER_EXCEPTION);
        }
    }

    @Override
    public void updateInfo(Student student) {
        int num = studentMapper.updateInfo(student);
        if (num == 0) {
            throw  new MyException(ExceptionEnum.UPDATE_PARAMETER_EXCEPTION);
        }
    }

    @Override
    public void uploadResume(Student student) {
        int num = studentMapper.uploadResume(student);
        if (num == 0) {
            throw  new MyException(ExceptionEnum.FILE_UPLOAD_EXCEPTION);
        }
    }

    @Override
    public Student downloadInfo(Integer sid) {
        Student student = studentMapper.downloadInfo(sid);
        if (student == null){
            throw new MyException(ExceptionEnum.FILE_DOWNLOAD_EXCEPTION);
        }
        return student;
    }

    @Override
    public void removeResume(Student student) {
        student = studentMapper.selectResumeBySid(student.getSid());
        if(student.getInformation() != null){
            student.setInformation(null);
            int num = studentMapper.removeResume(student);
            if (num == 0) {
                throw  new MyException(ExceptionEnum.FILE_REMOVE_EXCEPTION);
            }
            return;
        }
        throw new MyException(ExceptionEnum.FILE_REMOVE_EXCEPTION);
    }

    @Override
    public String selectNotice(Integer sid) {
        String msg = studentMapper.selectNotice(sid);
        System.out.println(msg);
        if(msg == null){
            throw new MyException(ExceptionEnum.SELECT_PARAMETER_EXCEPTION);
        }
        return msg;
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int selectUnderemployed() {
        return studentMapper.selectUnderemployed();
    }

    @Override
    public int selectEmployment() {
        return studentMapper.selectEmployment();
    }
}
