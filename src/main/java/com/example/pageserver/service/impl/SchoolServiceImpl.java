package com.example.pageserver.service.impl;

import com.example.pageserver.entity.School;
import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.children.MyException;
import com.example.pageserver.mapper.SchoolMapper;
import com.example.pageserver.service.SchoolService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl implements SchoolService {

    @Resource
    SchoolMapper schoolMapper;
    @Override
    public Integer insert(School school) {
        return null;
    }

    @Override
    public School selectBySid(Integer sid) {
        return schoolMapper.selectBySid(sid);
    }

    @Override
    public School checkInfo(String username, String password) {
        School school = schoolMapper.checkInfo(username,password);
        if (school == null) {
            throw new MyException(ExceptionEnum.LOGIN_PARAMETER_EXCEPTION);
        }
        return school;
    }
}
