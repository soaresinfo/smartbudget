package com.soares.smartbudget;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = WebClinicaApplication.class)
public class SmartbudgetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartbudgetApplication.class, args);
	}

}
