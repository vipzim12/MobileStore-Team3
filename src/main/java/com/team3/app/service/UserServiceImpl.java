package com.team3.app.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.Role;
import com.team3.app.entities.User;
import com.team3.app.repository.RoleRepository;
import com.team3.app.repository.UserRepository;
import com.team3.app.utils.HttpObject;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public Object getAll() {
		return new HttpObject(true, repository.findAll());
	}

	@Override
	public Object insertOne(User user,int[] rolesArr) {
		if(rolesArr!=null) {
			Set<Role> roles = new HashSet<Role>();
			for (int i : rolesArr) {
				Optional<Role> a = roleRepository.findById(i);
				if(a.isPresent()) {
					roles.add(a.get());
				}
			}
			user.setRoles(roles);
		}
		try {
			repository.save(user);
		} catch (Exception e) {
			return new HttpObject(false, "Add User Failed");
		}
		return new HttpObject(true, "Add User successfully");
	}

	@Override
	public Object deleteOne(int id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return new HttpObject(true, "Delete User successfully");
		}else {
			return new HttpObject(false, "User with id="+id+" do not exists");
		}
	}

	@Override
	public Object editOne(User user,int[] rolesArr) {
		if(repository.existsById(user.getId())) {
			if(rolesArr!=null) {
				Set<Role> roles = new HashSet<Role>();
				for (int i : rolesArr) {
					Optional<Role> a = roleRepository.findById(i);
					if(a.isPresent()) {
						roles.add(a.get());
					}
				}
				user.setRoles(roles);
			}
			try {
				repository.save(user);
			} catch (Exception e) {
				return new HttpObject(false, "Edit User Failed");
			}
			return new HttpObject(true, "Edit User successfully");
		}else {
			return new HttpObject(false, "User with id="+user.getId()+" do not exists");
		}
	}
	
	
}
