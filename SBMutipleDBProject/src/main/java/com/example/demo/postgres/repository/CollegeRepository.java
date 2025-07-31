package com.example.demo.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.postgres.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer> {

}
