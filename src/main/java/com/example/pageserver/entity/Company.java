package com.example.pageserver.entity;

import lombok.Data;

@Data
public class Company {
    private Integer cid;
    private String name;
    private String address;
    private String telephone;
    private String level;
}
