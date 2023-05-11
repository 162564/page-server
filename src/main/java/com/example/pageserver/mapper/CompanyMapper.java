package com.example.pageserver.mapper;

import com.example.pageserver.entity.Company;

import java.util.List;

public interface CompanyMapper {
    Company selectByCid(Integer cid);

    Company checkInfo(String username, String password);
    List<Company> selectAll();
    Company selectSend(Integer cid);
    int sendResume(Company company);
    int updateInfo(Company company);
    Company selectAllApply(Integer cid);
    Company selectAllEmployee(Integer cid);
    int applyEmployee(Company company);
    int puaEmployee(Company company);
}
