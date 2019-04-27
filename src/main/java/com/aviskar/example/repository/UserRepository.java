package com.aviskar.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviskar.example.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findOneByEmail(String email);

	User findOneByEmailAndPassword(String email, String password);
}
