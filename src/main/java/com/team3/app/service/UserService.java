package com.team3.app.service;

import com.team3.app.entities.User;

public interface UserService {
	Object getAll();
	Object insertOne(User user,int[] rolesArr);
	Object deleteOne(int id);
	Object editOne(User user,int[] rolesArr);
}
