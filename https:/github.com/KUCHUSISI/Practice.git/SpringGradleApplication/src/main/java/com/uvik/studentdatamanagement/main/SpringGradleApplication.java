package com.uvik.studentdatamanagement.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.uvik")
@EnableMongoRepositories("com.uvik.repository")
@EnableMongoAuditing
@Configuration
public class SpringGradleApplication
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringGradleApplication.class, args);
	}
}