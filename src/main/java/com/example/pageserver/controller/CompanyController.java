package com.example.pageserver.controller;

import com.example.pageserver.entity.Company;
import com.example.pageserver.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Resource
    CompanyService companyService;

    @GetMapping("/select")
    public Company selectByCid(Integer cid){
        return companyService.selectByCid(cid);
    }
}
