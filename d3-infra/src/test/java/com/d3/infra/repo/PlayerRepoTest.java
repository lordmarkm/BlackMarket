package com.d3.infra.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d3.common.constants.Profiles;
import com.d3.common.model.player.Player;
import com.d3.infra.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles(Profiles.TEST)
public class PlayerRepoTest {

	@Autowired
	private PlayerRepo players;
	
	@Before
	public void setup() {
		players.deleteAll();
	}
	
	@Test
	public void testCreate() {
		Player player = new Player();
		player.setBtag("Baldy#1682");
		players.save(player);
	}
	
	@Test
	public void testRetrieve() {
		String btag = "Baldy#1662";
		Player player = new Player();
		player.setBtag(btag);
		players.save(player);
		
		Player baldy = players.findByBtag(btag);
		assertNotNull(baldy);
		assertEquals(btag, baldy.getBtag());
	}
	
}
