package com.d3.infra.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.d3.common.constants.Profiles;
import com.d3.infra.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@ActiveProfiles(Profiles.TEST)
@PropertySource("classpath:test.properties")
public class PlayerRepoTest {

	@Test
	public void lol() {
		System.out.println("hello");
	}
	
}
