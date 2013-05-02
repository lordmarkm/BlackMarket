package com.d3.web.html.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.d3.common.model.player.Player;
import com.d3.infra.repo.PlayerRepo;

@Controller
public class PlayerHomeController {

	@Autowired
	private PlayerRepo players;
	
	@RequestMapping("/{btag}")
	public ModelAndView home(String btag) {
		Player player = players.findByBTag(btag);
		
		return new ModelAndView("home")
			.addObject("player", player);
	}
	
}
