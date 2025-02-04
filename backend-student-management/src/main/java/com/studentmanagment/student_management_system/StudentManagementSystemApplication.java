package com.studentmanagment.student_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.studentmanagment.controller", "com.studentmanagment.entity","com.studentmanagment.service"})
@EntityScan(basePackages = {"com.studentmanagment.entity"})
@EnableJpaRepositories({"com.studentmanagment.repository"})
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

}
