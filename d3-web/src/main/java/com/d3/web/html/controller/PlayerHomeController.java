package com.d3.web.html.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public interface PlayerHomeController {
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/u/{btag}")
	public ModelAndView profile(@PathVariable("btag") String btag);
}
