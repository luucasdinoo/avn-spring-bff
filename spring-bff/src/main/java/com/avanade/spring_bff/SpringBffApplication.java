package com.avanade.spring_bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBffApplication.class, args);
	}

}
