package com.aviskar.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aviskar.example.model.Student;
import com.aviskar.example.repository.StudentRepository;
import com.aviskar.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student findOne(Long id) {
		return studentRepository.findById(id).get();
	}

	public void saveOrUpdate(Student student) {
		studentRepository.save(student);
	}

	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}
