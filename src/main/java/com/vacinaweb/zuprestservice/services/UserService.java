package com.vacinaweb.zuprestservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinaweb.zuprestservice.entities.User;
import com.vacinaweb.zuprestservice.entities.Vaccine;
import com.vacinaweb.zuprestservice.enums.VaccineStatus;
import com.vacinaweb.zuprestservice.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		 
		return repository.findAll();
	}
	
	public User findById(Long id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		
		return repository.save(obj);
	}
	
	public User addVaccine(Long id,Vaccine vaccine) {
		User entity = repository.getOne(id);
		vaccine.setVaccineStatus(VaccineStatus.VACCINED);
		vaccine.setPatient(entity);
		entity.addVaccine(vaccine);
		return repository.save(entity);
	}
}
