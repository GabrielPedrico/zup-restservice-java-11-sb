package com.vacinaweb.zuprestservice.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vacinaweb.zuprestservice.entities.User;
import com.vacinaweb.zuprestservice.entities.Vaccine;
import com.vacinaweb.zuprestservice.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User obj = service.findById(id);
		return ResponseEntity.ok(obj);

	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		try {
			obj = service.insert(obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
					.toUri();
			return ResponseEntity.created(uri).body(obj);
		}catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(obj);
		}

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Vaccine> addVaccine(@PathVariable Long id, @RequestBody Vaccine vaccine) {
		try {
			service.addVaccine(id, vaccine);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vaccine.getId())
					.toUri();
			return ResponseEntity.created(uri).body(vaccine);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(vaccine);
		}
	}
}
