package com.team3.app.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.team3.app.entities.User;

public interface UserService {
	Object getAll();
	Object getOne(int id);
	Object insertOne(User user);
	Object deleteOne(int id);
	Object editOne(User user);
	Object checkAdmin(String username, String password);
	Object checkClient(String username, String password);
	Object registorClient(User user);
}
