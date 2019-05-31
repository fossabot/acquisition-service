package com.acquisition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.acquisition.mapper"})
public class SurgingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SurgingApplication.class, args);
	}

}
