package com.abs.service.createpdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.abs.service.createpdf","com.abs.infrastructure.spring"})
@EnableEurekaClient
@EnableDiscoveryClient
public class AbsServiceCreatepdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbsServiceCreatepdfApplication.class, args);
	}
}
