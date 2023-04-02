package com.example.pageserver.service;

import com.example.pageserver.entity.Company;

public interface CompanyService {
    Company selectByCid(Integer cid);
}
