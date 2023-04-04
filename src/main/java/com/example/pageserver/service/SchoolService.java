package com.example.pageserver.service;

import com.example.pageserver.entity.School;

public interface SchoolService {
    /*insert*/
    Integer insert(School school);
    /*select*/
    School selectBySid(Integer sid);

    School checkInfo(String username, String password);
}
