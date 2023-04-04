package com.example.pageserver.service.impl;

import com.example.pageserver.entity.School;
import com.example.pageserver.entity.Student;
import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.children.MyException;
import com.example.pageserver.mapper.CompanyMapper;
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

    @Override
    public Company checkInfo(String username, String password) {
        Company company = companyMapper.checkInfo(username,password);
        if (company == null) {
            throw new MyException(ExceptionEnum.LOGIN_PARAMETER_EXCEPTION);
        }
        return company;
    }
}
