package com.example.studentdatamanagement;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@PropertySource(value = "file:${user.home}/application.properties")
public class WebMvcConfiguration extends WebMvcConfigurationSupport
{ 
	    @Bean
	    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev()
		{
	        return new PropertySourcesPlaceholderConfigurer();
	    }
}