package com.yugioh.fm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yugioh.fm.services.MockDatabase;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private MockDatabase mockDatabase;

	@Bean
	public boolean createDatabase() throws Exception {
		mockDatabase.instantiate();
		return true;
	}
}