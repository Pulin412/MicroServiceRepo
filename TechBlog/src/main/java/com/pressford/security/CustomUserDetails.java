package com.pressford.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pressford.entity.Role;
import com.pressford.entity.User;

/**
 * Provides a basic implementation of the UserDetails interface
 */
public class CustomUserDetails implements UserDetails{

	private Collection<? extends GrantedAuthority> authorities;
	private String password;
	private String username;
	
	
	/**
	 * @param authorities
	 * @param password
	 * @param username
	 */
	public CustomUserDetails(User user) {
		super();
		this.authorities = translate(user.getRoles());
		this.password = user.getPassword();
		this.username = user.getUsername();
	}

    /**
     * Translates the List<Role> to a List<GrantedAuthority>
     * @param roles the input list of roles.
     * @return a list of granted authorities
     */
	private Collection<? extends GrantedAuthority> translate(List<Role> roles) {

		List<GrantedAuthority> authorities = new ArrayList<>();
		for(Role role : roles) {
			String name = role.getName().toUpperCase();
			// to make sure that all roles start with the prefix - ROLE_
			if(!name.startsWith("ROLE_")) {
				name = "ROLE_" + name;
			}
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
