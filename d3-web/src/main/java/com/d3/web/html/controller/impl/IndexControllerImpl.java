package com.d3.web.html.controller.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.d3.web.html.controller.IndexController;

@Component
public class IndexControllerImpl implements IndexController {

	public ModelAndView index() {
		return new ModelAndView("index");
	}

}
