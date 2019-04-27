package com.aviskar.example.service;

import java.util.List;

import com.aviskar.example.model.Student;

public interface StudentService {

	List<Student> findAll();

	Student findOne(Long id);

	void saveOrUpdate(Student student);

	void delete(Long id);
}
