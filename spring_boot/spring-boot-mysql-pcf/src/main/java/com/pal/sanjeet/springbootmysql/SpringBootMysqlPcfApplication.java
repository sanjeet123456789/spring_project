package com.pal.sanjeet.springbootmysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootMysqlPcfApplication implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/addcomment").setViewName("comment");
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMysqlPcfApplication.class, args);
	}

}
