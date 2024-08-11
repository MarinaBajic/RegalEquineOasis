package com.reo.rider_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RiderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiderServiceApplication.class, args);
	}

}
