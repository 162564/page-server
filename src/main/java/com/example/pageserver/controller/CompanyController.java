package com.example.pageserver.controller;

import com.example.pageserver.entity.Company;
import com.example.pageserver.entity.Student;
import com.example.pageserver.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin
public class CompanyController {

    @Resource
    CompanyService companyService;

    @GetMapping("/select/{cid}")
    public Company selectByCid(@PathVariable Integer cid){
        return companyService.selectByCid(cid);
    }

    @GetMapping("/checkInfo/{username}/{password}")
    public Boolean checkInfo(@PathVariable String password, @PathVariable String username){
        companyService.checkInfo(username, password);
        return true;
    }
    @GetMapping("selectAll")
    public List<Company> selectAll(){
        return companyService.selectAll();
    }
    @PostMapping("sendResume/{sid}/{cid}")
    public Boolean sendResume(@PathVariable Integer cid, @PathVariable Integer sid){
        companyService.sendResume(cid,sid);
        return true;
    }
    @GetMapping("select/{username}/{password}")
    public Company selectByUAW(@PathVariable String password, @PathVariable String username){
        return companyService.checkInfo(username,password);
    }
    @PutMapping("updateInfo/{cid}/{name}/{companyType}/{principal}/{request}/{telephone}/{salary}/{scale}/{address}/{postIntroduce}/{companyIntroduce}/{date}")
    public Boolean updateInfo(Company company, @PathVariable Long date){
        company.setBeginDate(new Timestamp(date));
        companyService.updateInfo(company);
        return true;
    }
    @GetMapping("selectAllApply/{cid}")
    public List<Student> selectAllApply(@PathVariable Integer cid){
        return companyService.selectAllApply(cid);
    }
    @GetMapping("selectAllEmployee/{cid}")
    public List<Student> selectAllEmployee(@PathVariable Integer cid){
        return companyService.selectAllEmployee(cid);
    }
    @PutMapping("applyEmployee/{sid}/{cid}")
    public Boolean applyEmployee(@PathVariable Integer cid, @PathVariable Integer sid){
        companyService.applyEmployee(cid,sid);
        return true;
    }
    @PutMapping("puaEmployee/{cid}/{sid}")
    public Boolean puaEmployee(@PathVariable Integer cid, @PathVariable Integer sid){
        companyService.puaEmployee(cid,sid);
        return true;
    }
}
