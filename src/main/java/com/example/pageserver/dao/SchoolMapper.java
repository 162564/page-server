package com.example.pageserver.dao;


import com.example.pageserver.entity.School;
public interface SchoolMapper {
    School selectBySid(Integer sid);
}
