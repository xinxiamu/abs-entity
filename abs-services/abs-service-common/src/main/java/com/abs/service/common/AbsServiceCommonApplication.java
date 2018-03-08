package com.abs.service.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.abs.service","com.abs.infrastructure.spring"})
public class AbsServiceCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsServiceCommonApplication.class, args);
	}
}
