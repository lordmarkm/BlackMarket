package com.d3.web.html.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.d3.web.dtos.RegForm;

@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public ModelAndView registrationPage() {
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@Valid RegForm form) {
		return null;
	}
	
}
