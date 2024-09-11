package com.santojes.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// Central instance where other services will get registered
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
