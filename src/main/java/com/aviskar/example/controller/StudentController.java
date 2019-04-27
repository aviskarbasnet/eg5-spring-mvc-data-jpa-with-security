package com.aviskar.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aviskar.example.model.Student;
import com.aviskar.example.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(path = "/students", method = RequestMethod.GET)
	public String students(Model model, Authentication authentication) {
		model.addAttribute("students", studentService.findAll());
		model.addAttribute("username", authentication.getName());
		return "student-list";
	}

	@RequestMapping(path = "/add-student", method = RequestMethod.GET)
	public String addStudent(Model model, Authentication authentication) {
		model.addAttribute("student", new Student());
		model.addAttribute("username", authentication.getName());
		return "student-form";
	}

	@RequestMapping(path = "/add-student", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute Student student) {
		studentService.saveOrUpdate(student);
		return "redirect:/students";
	}

	@RequestMapping(path = "/edit-student", method = RequestMethod.GET)
	public String editStudent(@RequestParam Long id, Model model, Authentication authentication) {
		model.addAttribute("student", studentService.findOne(id));
		model.addAttribute("username", authentication.getName());
		return "student-form";
	}

	@RequestMapping(path = "/edit-student", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute Student student) {
		studentService.saveOrUpdate(student);
		return "redirect:/students";
	}

	@RequestMapping(path = "/delete-student", method = RequestMethod.GET)
	public String deleteStudent(@RequestParam Long id) {
		studentService.delete(id);
		return "redirect:/students";
	}
}
