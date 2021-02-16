package com.vacinaweb.zuprestservice.resource;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacinaweb.zuprestservice.entities.Cpf;
import com.vacinaweb.zuprestservice.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
			
			Cpf cpf = new Cpf("41531952860");
			Date date = new Date(System.currentTimeMillis());
			User u = new User(1L, "Gabriel Pedrico", "gabriel.pedrico@fatec.sp.gov.br",cpf,date);
			return ResponseEntity.ok().body(u);
	}
}
