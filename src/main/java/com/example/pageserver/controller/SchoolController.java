package com.example.pageserver.controller;

import com.example.pageserver.entity.School;
import com.example.pageserver.service.SchoolService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Resource
    SchoolService schoolService;

    @GetMapping("/select")
    public School selectBySid(Integer sid){
        return schoolService.selectBySid(sid);
    }
}
