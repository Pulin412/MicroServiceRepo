package com.pressford.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pressford.entity.Role;
import com.pressford.entity.User;
import com.pressford.entity.UserRegistration;
import com.pressford.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/register")
	public String register(@RequestBody UserRegistration userRegistration) {
		if(userService.getUser(userRegistration.getUsername()) != null) {
			return "User already exists";
		}
		userService.save(new User(userRegistration.getUsername(), userRegistration.getPassword(), Arrays.asList(new Role("USER"))));
		return "User created";
	}
	
	@GetMapping(value = "/users")
	public List<User> users(){
		return userService.getAllUsers();
	}
	
}
