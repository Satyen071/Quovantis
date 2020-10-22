package com.example.DemoRecruitment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import Controller.RecruiteController;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackageClasses = RecruiteController.class)
public class DemoRecruitmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRecruitmentApplication.class, args);
	}

}
