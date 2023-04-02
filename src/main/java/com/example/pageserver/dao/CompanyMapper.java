package com.example.pageserver.dao;

import com.example.pageserver.entity.Company;

public interface CompanyMapper {
    Company selectByCid(Integer Cid);
}
