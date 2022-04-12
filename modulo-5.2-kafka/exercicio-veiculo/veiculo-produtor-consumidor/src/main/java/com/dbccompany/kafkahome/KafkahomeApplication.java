package com.dbccompany.kafkahome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.dbccompany.kafkahome")
public class KafkahomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkahomeApplication.class, args);
	}

}
