package com.example.pageserver.service.impl;

import com.example.pageserver.dao.SchoolMapper;
import com.example.pageserver.entity.School;
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
}
