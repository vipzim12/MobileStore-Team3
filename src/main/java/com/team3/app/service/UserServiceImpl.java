package com.team3.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.Role;
import com.team3.app.entities.User;
import com.team3.app.repository.RoleRepository;
import com.team3.app.repository.UserRepository;
import com.team3.app.security.JwtService;
import com.team3.app.security.MD5;
import com.team3.app.utils.HttpObject;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	MD5 encoder;
	@Autowired
	JwtService jwtService;

	@Override
	public Object getAll() {
		List<User> a = repository.findAll();
		a.forEach(x->{
			x.setPassword(null);
		});
		return new HttpObject(true, a);
	}

	@Override
	public Object insertOne(User user) {
		try {
			user.setPassword(encoder.encode(user.getPassword()));
			user.setStatus(1);
			repository.save(user);
			return new HttpObject(true, "Add user successfully");
		} catch (Exception e) {
			return new HttpObject(false, "Add user failed");
		}
	}

	@Override
	public Object deleteOne(int id) {
		if(repository.existsById(id)) {
			User user = repository.getOne(id);
			user.setStatus(0);
			repository.save(user);
			return new HttpObject(true, "Delete User successfully");
		}else {
			return new HttpObject(false, "User with id="+id+" do not exists");
		}
	}

	@Override
	public Object editOne(User user) {
		Optional<User> opt = repository.findById(user.getId());
		try {
			if(opt.isPresent()) {
				if(user.getPassword()==null||user.getPassword().equals("")) {
					user.setPassword(opt.get().getPassword());
				}else {
					user.setPassword(encoder.encode(user.getPassword()));
				}
				repository.save(user);
				return new HttpObject(true, "Edit User successfully");
			}else {
				return new HttpObject(false, "User with id="+user.getId()+" do not exists");
			}
		} catch (Exception e) {
			return new HttpObject(false, "Edit user failed");
		}
	}

	@Override
	public Object checkAdmin(String username, String password) {
		User userDes = repository.findByUsername(username);
		if(userDes!=null&&userDes.getStatus()==1) {
			if(encoder.encode(password).trim().equals(userDes.getPassword().trim())) {
				if(userDes.getRole().getName().equals("ADMIN")) {
					Map<String, Object> a = new HashMap<String, Object>();
					a.put("token", jwtService.generateTokenLogin(username));
					userDes.setPassword(null);
					a.put("user", userDes);
					return new HttpObject(true, a);
				}else {
					return new HttpObject(false, "Login by admin account only.");
				}
			}else {
				return new HttpObject(false, "Wrong password");
			}
		}
		return new HttpObject(false, "Username does not exists");
	}
	
	@Override
	public Object checkClient(String username, String password) {
		User userDes = repository.findByUsername(username);
		System.out.println(userDes.toString());
		if(userDes!=null&&userDes.getStatus()==1) {
			if(encoder.encode(password).trim().equals(userDes.getPassword().trim())) {
				Map<String, Object> a = new HashMap<String, Object>();
				a.put("token", jwtService.generateTokenLogin(username));
				userDes.setPassword(null);
				a.put("user", userDes);
				return new HttpObject(true, a);
			}else {
				return new HttpObject(false, "Wrong password");
			}
		}
		return new HttpObject(false, "Username does not exists");
	}

	@Override
	public Object getOne(int id) {
		Optional<User> opt = repository.findById(id);
		if (opt.isPresent()) {
			opt.get().setPassword(null);
			return new HttpObject(true, opt.get());
		}
		return new HttpObject(false, "Not found");
	}

	@Override
	public Object registorClient(User user) {
		try {
			user.setId(0);
			user.setPassword(encoder.encode(user.getPassword()));
			user.setStatus(1);
			Role role = roleRepository.getOne(2);
			user.setRole(role);
			repository.save(user);
			return new HttpObject(true, "Registor user successfully");
		} catch (Exception e) {
			return new HttpObject(false, "Registor user failed");
		}
	}

	
	
}
