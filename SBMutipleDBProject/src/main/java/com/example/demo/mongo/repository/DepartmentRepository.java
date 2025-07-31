package com.example.demo.mongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.mongo.documents.Department;

public interface DepartmentRepository extends MongoRepository<Department, Integer> {
	
}
