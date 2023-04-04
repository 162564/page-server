package com.example.pageserver.entity;

import lombok.Data;

@Data
public class Student {
    private Integer sid;
    private Integer age;
    private String name;
    private String telephone;
    private String company;
    private String address;
    private Boolean state;
    private String username;
    private String password;
}
