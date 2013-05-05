package com.d3.web.html.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.d3.common.model.player.Player;
import com.d3.common.utils.BtagUtils;
import com.d3.infra.repo.PlayerRepo;
import com.d3.web.html.controller.PlayerHomeController;

@Component
public class PlayerHomeControllerImpl implements PlayerHomeController {

	@Autowired
	private PlayerRepo players;
	
	@Override
	public ModelAndView profile(String btag) {
		btag = BtagUtils.fromUrlSafe(btag);
		Player player = players.findByBtag(btag);
		
		return new ModelAndView("home")
			.addObject("player", player);
	}

}
