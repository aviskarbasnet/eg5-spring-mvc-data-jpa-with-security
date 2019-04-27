package com.aviskar.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aviskar.example.model.User;
import com.aviskar.example.service.UserService;

@Controller
public class RootController {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String root() {
		return "redirect:/students";
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(path = "/sign-up", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		return "sign-up";
	}

	@RequestMapping(path = "/sign-up", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("user") User user) {
		if (!StringUtils.hasLength(user.getEmail()) || !StringUtils.hasLength(user.getPassword())) {
			return "redirect:/sign-up?invalid";
		}
		User userInDB = userService.findOneByEmail(user.getEmail());
		if (userInDB != null) {
			return "redirect:/sign-up?exists";
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveOrUpdate(user);
		return "redirect:/login?signup";
	}
}
