package com.vladimirstanciu.accessgranter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.vladimirstanciu.accessgranter.domain")
@EnableJpaRepositories("com.vladimirstanciu.accessgranter.repository")
@ComponentScan({"com.vladimirstanciu.accessgranter.service", "com.vladimirstanciu.accessgranter.rest"})
public class AccessGranterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccessGranterApplication.class, args);
	}
}
