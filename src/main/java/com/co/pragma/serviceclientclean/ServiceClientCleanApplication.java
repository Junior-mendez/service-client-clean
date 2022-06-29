package com.co.pragma.serviceclientclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceClientCleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientCleanApplication.class, args);
	}

}
