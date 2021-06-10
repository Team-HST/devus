package com.hst.devus.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DevusConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevusConfigApplication.class, args);
	}

}
