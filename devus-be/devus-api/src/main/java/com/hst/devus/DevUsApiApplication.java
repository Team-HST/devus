package com.hst.devus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.hst.devus.configuration.props.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	ApplicationProperties.class
})
@EnableJpaAuditing
public class DevUsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevUsApiApplication.class, args);
	}

}
