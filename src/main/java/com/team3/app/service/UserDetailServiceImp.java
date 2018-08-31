package com.team3.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.team3.app.entities.User;
import com.team3.app.repository.UserRepository;

@Service
public class UserDetailServiceImp implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(user.getRole().getName()));
		if(user!=null&&user.getStatus()==1) {
			UserDetails userDetails = new org.springframework.security.core.userdetails.
					User(user.getUsername(), user.getPassword(), auth);
			return userDetails;
		}
		return null;
	}
	
}
