package com.vacinaweb.zuprestservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vacinaweb.zuprestservice.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
