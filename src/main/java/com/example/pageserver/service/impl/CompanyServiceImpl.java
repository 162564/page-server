package com.example.pageserver.service.impl;

import com.example.pageserver.dao.CompanyMapper;
import com.example.pageserver.entity.Company;
import com.example.pageserver.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    CompanyMapper companyMapper;
    @Override
    public Company selectByCid(Integer cid) {
        return companyMapper.selectByCid(cid);
    }
}
