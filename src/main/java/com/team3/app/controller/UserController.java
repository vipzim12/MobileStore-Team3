package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team3.app.entities.User;
import com.team3.app.service.UserService;

@RestController
@RequestMapping("pages/users")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService service;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	Object viewAll() {
		System.out.println(service.getAll());
		return service.getAll();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	Object addOne(User user, int rolesArr[]) {
		return service.insertOne(user,rolesArr);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	Object deleteOne(@PathVariable("id")int id) {
		return service.deleteOne(id);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	Object editOne(User user,int[] rolesArr) {
		return service.editOne(user,rolesArr);
	}
	
}
