package com.pressford;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pressford.entity.Role;
import com.pressford.entity.User;
import com.pressford.repository.UserRepository;
import com.pressford.security.CustomUserDetails;
import com.pressford.service.UserService;

@SpringBootApplication
public class MainApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	/**
	 * Password grants are switched on by injecting an AuthenticationManager.
	 * Here, we setup the builder so that the userDetailsService is the one we coded.
	 * @param builder
	 * @param repository
	 * @throws Exception
	 */
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository, UserService service) throws Exception{
		if(repository.count() == 0) {
			service.save(new User("admin", "adminpassword", Arrays.asList(new Role("ADMIN"), new Role("USER"))));
			service.save(new User("admin2", "adminpassword", Arrays.asList(new Role("ADMIN"), new Role("USER"))));
			builder.userDetailsService(userDetailsService(repository)).passwordEncoder(passwordEncoder);
		}
	}

	/**
	 * return an instance of our CustomUserDetails.
	 * @param repository
	 * @return
	 */
	private UserDetailsService userDetailsService(UserRepository repository) {
		return username -> new CustomUserDetails(repository.findByUsername(username));
	}

}
