package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDAO extends JpaRepository<StudentEntity, Long>{

}
