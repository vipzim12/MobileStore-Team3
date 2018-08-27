package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.Category;
import com.team3.app.service.CategoryServiceIpm;
import com.team3.app.service.GroupCategoriesServiceIpm;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("http://localhost:4200")
public class CategoryController {
	@Autowired CategoryServiceIpm service;
	
	@Autowired GroupCategoriesServiceIpm gCategoryService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Object viewAll() {
		return service.getAll();
	}
	
	
	
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	Object viewAllBGCategoryId(@PathVariable int id) {
		return service.getAllByGCategory(id);
	}
	
	@RequestMapping(value = "/group-category", method = RequestMethod.GET)
	Object getGroupCategory() {
		return gCategoryService.getAll();
	}

	@RequestMapping(value = "/add-new", method = RequestMethod.POST)
	Object addOne(@RequestBody Category category) {
		return service.insertOne(category);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	Object deleteOne(@PathVariable("id")int id) {
		return service.deleteOne(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	Object editOne(@RequestBody Category category) {
		return service.editOne(category);
	}
	
	@GetMapping("/edit/{id}")
	Object getOne(@PathVariable int id) {
		return service.getOne(id);
	}

}
