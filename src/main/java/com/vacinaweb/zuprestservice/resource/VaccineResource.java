package com.vacinaweb.zuprestservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacinaweb.zuprestservice.entities.Vaccine;
import com.vacinaweb.zuprestservice.services.VaccineService;

@RestController
@RequestMapping(value = "/vaccines")
public class VaccineResource {
		
		@Autowired
		private VaccineService service;
		
		@GetMapping
		public ResponseEntity<List<Vaccine>> findAll(){
			List<Vaccine> list = service.findAll();
			return ResponseEntity.ok().body(list);
			}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Vaccine> findById(@PathVariable Long id){
			
			Vaccine obj = service.findById(id);
			return ResponseEntity.ok(obj);
			
		}
		
}
