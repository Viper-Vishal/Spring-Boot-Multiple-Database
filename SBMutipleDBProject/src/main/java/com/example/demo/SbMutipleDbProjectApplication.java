package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.mongo.documents.Department;
import com.example.demo.mongo.repository.DepartmentRepository;
import com.example.demo.mysql.entity.User;
import com.example.demo.mysql.repository.UserRepository;
import com.example.demo.postgres.entity.College;
import com.example.demo.postgres.repository.CollegeRepository;

@SpringBootApplication
public class SbMutipleDbProjectApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SbMutipleDbProjectApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		User admin = User.builder()
			.email("example1@gmail.com")
			.username("example1")
			.password("123451")
			.build(); 
		
		userRepository.save(admin);
		
		
		System.out.println("User is created :- " + admin.getId());
		
		College college = College.builder()
				.collegeName("MMC1")
				.collegeAddress("Kothrud1")
				.collegeEmail("mmc1@pdcc.com")
				.collegePhone("9890030681")
				.build();
		
		collegeRepository.save(college);
		
		System.out.println("College is created :- " + college.getId());
		
		Department department = Department.builder()
			.name("IT")
			.build();
		
		departmentRepository.save(department);
		
		System.out.println("Collage is saved :- " + department.getId());
	}
	


}
