package com.example.pageserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.example.pageserver.dao")
@SpringBootApplication
public class PageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PageServerApplication.class, args);
	}

}
