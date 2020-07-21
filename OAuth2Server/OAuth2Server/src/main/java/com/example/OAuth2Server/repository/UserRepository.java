package com.example.OAuth2Server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.OAuth2Server.model.User;

@Service
public interface UserRepository extends JpaRepository<User, String>{
	User findByEmail(String email);

}
