package com.santojes.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
// Config Server provides an HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content)
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
