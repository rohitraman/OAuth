package com.example.OAuth2Server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.OAuth2Server.model.User;
import com.example.OAuth2Server.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByEmail(username);
		if(user==null)
			throw new UsernameNotFoundException("Username not found");
		
		return new MyUsersDetails(user);
	}

}
