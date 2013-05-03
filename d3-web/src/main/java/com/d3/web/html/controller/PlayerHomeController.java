package com.d3.web.html.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d3.common.model.player.Player;
import com.d3.infra.repo.PlayerRepo;

@Controller
public class PlayerHomeController {

	static Logger log = LoggerFactory.getLogger(PlayerHomeController.class);
	
	@Autowired
	private PlayerRepo players;
	
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/u/{btag}")
	public ModelAndView profile(@PathVariable String btag) {
		
		log.info("Profile page requested for btag=[{}]", btag);
		
		Player player = players.findByBtag(btag);
		
		return new ModelAndView("home")
			.addObject("player", player);
	}
	
}
