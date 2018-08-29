package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.User;
import com.team3.app.service.UserService;

@RestController
@RequestMapping("pages/user")
@CrossOrigin(origins= {"http://localhost:4200","*"})
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping(value = "/select")
	Object viewAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/select/{id}")
	Object viewAll(@PathVariable int id) {
		return service.getOne(id);
	}

	@PostMapping(value = "/insert")
	Object addOne(@RequestBody User user) {
		return service.insertOne(user);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	Object deleteOne(@PathVariable("id")int id) {
		return service.deleteOne(id);
	}
	
	@PutMapping(value = "/edit")
	Object editOne(@RequestBody User user) {
		return service.editOne(user);
	}
	
}
