package com.reo.horse_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HorseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorseServiceApplication.class, args);
	}

}
