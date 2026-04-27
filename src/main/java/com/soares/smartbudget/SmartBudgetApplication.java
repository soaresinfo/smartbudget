package com.soares.smartbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackageClasses = SmartBudgetApplication.class)
public class 	SmartBudgetApplication {

	public static void main(String[] args) {

		SpringApplication.run(SmartBudgetApplication.class, args);
	}

}
