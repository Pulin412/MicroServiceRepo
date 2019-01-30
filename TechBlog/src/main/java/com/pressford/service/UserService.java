package com.pressford.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pressford.entity.User;
import com.pressford.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void save(User user) {
		user.setPassword(getPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public User getUser(String username) {
		return userRepository.findByUsername(username);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
}
