package com.vacinaweb.zuprestservice.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.vacinaweb.zuprestservice.entities.User;
import com.vacinaweb.zuprestservice.entities.Vaccine;
import com.vacinaweb.zuprestservice.enums.VaccineStatus;
import com.vacinaweb.zuprestservice.repositories.UserRepository;
import com.vacinaweb.zuprestservice.repositories.VaccineRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
			
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VaccineRepository vacinneRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Gabriel Pedrico", "gabriel.pedrico@fatec.sp.gov.br", "41531952860", Instant.parse("2019-06-20T19:53:07Z"));
		User u2 = new User(null, "Juliana Villela", "julianavillelacomunicacao@gmail.com", "34939607860", Instant.parse("2019-06-20T19:53:07Z"));
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Vaccine v1 = new Vaccine("CoronaVac", null, Instant.now(),VaccineStatus.VACCINED,u1);
		Vaccine v2 = new Vaccine("BCG/Tuberculose", null, Instant.now(),VaccineStatus.VACCINED,u1);
		Vaccine v3 = new Vaccine("CoronaVac", null, Instant.now(),VaccineStatus.VACCINED,u2);
		
		vacinneRepository.saveAll(Arrays.asList(v1,v2,v3));
		
	}
	
	
}
