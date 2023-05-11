package com.example.pageserver.controller;

import com.example.pageserver.entity.School;
import com.example.pageserver.service.SchoolService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
@CrossOrigin
public class SchoolController {
    @Resource
    SchoolService schoolService;

    @GetMapping("/select/{sid}")
    public School selectBySid(@PathVariable Integer sid){
        return schoolService.selectBySid(sid);
    }

    @GetMapping("/checkInfo/{username}/{password}")
    public Boolean checkInfo(@PathVariable String password, @PathVariable String username){
        schoolService.checkInfo(username, password);
        return true;
    }
    @GetMapping("select/{username}/{password}")
    public School selectByUAW(@PathVariable String password, @PathVariable String username){
        return schoolService.checkInfo(username,password);
    }
}
