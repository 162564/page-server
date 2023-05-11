package com.example.pageserver.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Data
public class Company {
    private Integer cid;
    private String username;
    private String password;
    private String name;
    private String companyType;
    private double salary;
    private String request;
    private String principal;
    private String postIntroduce;
    private String companyIntroduce;
    private String scale;
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Timestamp beginDate;
    private String address;
    private String telephone;
    private String employee;
    private String msg;
    private String readyEmployee;
}
