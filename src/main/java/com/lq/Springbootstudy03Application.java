package com.lq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.lq.springboot.dao")
@SpringBootApplication
public class Springbootstudy03Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootstudy03Application.class, args);
	}
}
