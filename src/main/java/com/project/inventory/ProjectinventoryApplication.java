package com.project.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
@EntityScan("com.project.inventory.entity")
public class ProjectinventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectinventoryApplication.class, args);
	}
        @Bean
        public RestTemplate getRestTemplate(){
            return new RestTemplate();
        }
}
