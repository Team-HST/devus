package com.hst.devus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.hst.devus.configurations.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	ApplicationProperties.class
})
public class DevUsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevUsApiApplication.class, args);
	}

}
