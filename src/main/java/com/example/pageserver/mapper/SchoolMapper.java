package com.example.pageserver.mapper;


import com.example.pageserver.entity.School;

public interface SchoolMapper {
    School selectBySid(Integer sid);
    School checkInfo(String username, String password);
}
