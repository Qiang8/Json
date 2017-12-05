package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class TestControllerApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(TestControllerApplication.class, args);
	}
}
