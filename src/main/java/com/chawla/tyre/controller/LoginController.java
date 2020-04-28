package com.chawla.tyre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.chawla.tyre.model.Login;
import com.chawla.tyre.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService service;

	@PostMapping("/login")
	public String login(Login login) {
		if (service.validateLogin(login))
			return "welcome";
		else
			return "invalidLogin";
	}
}
