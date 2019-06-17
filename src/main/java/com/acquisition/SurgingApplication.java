package com.acquisition;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages={"com.acquisition.mapper"})
public class SurgingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SurgingApplication.class, args);
	}
}
