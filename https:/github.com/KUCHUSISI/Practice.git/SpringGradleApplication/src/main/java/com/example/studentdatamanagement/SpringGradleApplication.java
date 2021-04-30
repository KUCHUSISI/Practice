package com.example.studentdatamanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.example")
@EnableMongoRepositories("com.example.repository")
@EnableMongoAuditing
public class SpringGradleApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringGradleApplication.class, args);
	}
}
