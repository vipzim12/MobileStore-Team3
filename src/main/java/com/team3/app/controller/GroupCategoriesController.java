package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.GroupCategory;
import com.team3.app.service.GroupCategoriesServiceIpm;

@RestController
@RequestMapping("/api/group-category")
@CrossOrigin("http://localhost:4200")
public class GroupCategoriesController {
	@Autowired GroupCategoriesServiceIpm service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Object viewAll() {
		return service.getAll();
	}

	
	@RequestMapping(value = "/add-new", method = RequestMethod.POST)
	Object addOne(@RequestBody GroupCategory gCategory) {
		return service.insertOne(gCategory);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	Object deleteOne(@PathVariable("id")int id) {
		return service.deleteOne(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	Object editOne(@RequestBody GroupCategory gCategory) {
		return service.editOne(gCategory);
	}
	
	@GetMapping("/edit/{id}")
	Object getOne(@PathVariable int id) {
		return service.getOne(id);
	}
}
