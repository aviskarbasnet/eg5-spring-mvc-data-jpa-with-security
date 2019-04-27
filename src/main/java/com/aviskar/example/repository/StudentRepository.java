package com.aviskar.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviskar.example.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
