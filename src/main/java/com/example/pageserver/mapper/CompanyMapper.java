package com.example.pageserver.mapper;

import com.example.pageserver.entity.Company;

public interface CompanyMapper {
    Company selectByCid(Integer Cid);

    Company checkInfo(String username, String password);
}
