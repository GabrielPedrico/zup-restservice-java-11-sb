package com.vacinaweb.zuprestservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacinaweb.zuprestservice.entities.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine,Long> {

}
