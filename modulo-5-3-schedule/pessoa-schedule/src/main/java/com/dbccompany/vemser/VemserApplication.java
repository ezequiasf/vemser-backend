package com.dbccompany.vemser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VemserApplication {

    public static void main(String[] args) {
        SpringApplication.run(VemserApplication.class, args);
    }

}
