package com.dbccompany.vemser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VemserApplication {

	public static void main(String[] args) {
		SpringApplication.run(VemserApplication.class, args);
	}

}
