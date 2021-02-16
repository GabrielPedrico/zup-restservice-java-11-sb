package com.vacinaweb.zuprestservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinaweb.zuprestservice.entities.Vaccine;
import com.vacinaweb.zuprestservice.repositories.VaccineRepository;

@Service
public class VaccineService {
	
	@Autowired
	private VaccineRepository repository;
	
	public List<Vaccine> findAll(){
		 
		return repository.findAll();
	}
	
	public Vaccine findById(Long id) {
		
		Optional<Vaccine> obj = repository.findById(id);
		return obj.get();
	}
}
