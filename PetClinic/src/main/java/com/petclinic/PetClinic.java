package com.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = "com.petclinic")  // component scan for @Controller annotation, @service and @Repository
@EntityScan(basePackages = "com.petclinic.bean")  // Enable @Entity annotation
@EnableJpaRepositories(basePackages = "com.petclinic.dao")  // spring jpa data enable
public class PetClinic {

	public static void main(String[] args) {
		SpringApplication.run(PetClinic.class, args);
	}
	
	@Bean				
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
