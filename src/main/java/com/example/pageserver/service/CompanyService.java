package com.example.pageserver.service;

import com.example.pageserver.entity.Company;
import com.example.pageserver.entity.Student;

import java.util.List;

public interface CompanyService {
    Company selectByCid(Integer cid);
    Company checkInfo(String username, String password);
    List<Company> selectAll();
    void sendResume(Integer cid,Integer sid);
    void updateInfo(Company company);
    List<Student> selectAllApply(Integer cid);
    List<Student> selectAllEmployee(Integer cid);
    void applyEmployee(Integer cid,Integer sid);
    void puaEmployee(Integer cid,Integer sid);
}
