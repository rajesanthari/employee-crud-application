package com.ranthari.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ranthari.app.model.DAOUser;

public interface UserRepository extends JpaRepository<DAOUser, Long> {
	DAOUser findByUsername(String username);
}
