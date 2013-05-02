package com.d3.infra.repo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d3.common.constants.Profiles;
import com.d3.common.model.items.UnidentifiedItem;
import com.d3.common.model.player.Player;
import com.d3.common.model.player.UnidBunch;
import com.d3.infra.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles(Profiles.TEST)
public class UnidItemRepoTest {

	@Autowired
	private PlayerRepo players;
	
	@Autowired
	private UnidItemRepo unids;
	
	@Autowired
	private UnidBunchRepo bunches;
	
	private String btag = "Baldy#1682";
	private String itemName = "Mempo of Twilight";
	
	@Before
	public void setup() {
		players.deleteAll();
		unids.deleteAll();
		bunches.deleteAll();
		
		UnidentifiedItem mempo = new UnidentifiedItem();
		mempo.setName(itemName);
		unids.save(mempo);
		
		UnidBunch mempos = new UnidBunch();
		mempos.setItem(mempo);
		mempos.setPrice(6000000000d);
		
		Player player = new Player();
		player.setBtag(btag);
		
		player.getUnids().add(mempos);
		mempos.setOwner(player);
		
		players.save(player);
	}
	
	@Test
	public void findBunches() {
		List<UnidBunch> mempos = bunches.findByItemName(itemName);
		assertTrue(mempos != null && !mempos.isEmpty());
		
		Player owner = mempos.get(0).getOwner();
		assertEquals(owner.getBtag(), btag);
	}
	
}
