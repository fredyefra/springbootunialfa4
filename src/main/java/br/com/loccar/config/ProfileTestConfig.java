package br.com.loccar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.loccar.service.DataService;

@Configuration
@Profile("test")
public class ProfileTestConfig {

	/**
	 * Perfil teste H2 drive
	 * 
	 **/

	@Autowired
	private DataService dataBaseService;

	@Bean
	public void startDatabaseTest() {
		dataBaseService.startDB();
	}
}