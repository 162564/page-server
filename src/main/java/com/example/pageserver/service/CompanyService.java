package com.example.pageserver.service;

import com.example.pageserver.entity.Company;
import com.example.pageserver.entity.Student;

public interface CompanyService {
    Company selectByCid(Integer cid);
    Company checkInfo(String username, String password);
}
