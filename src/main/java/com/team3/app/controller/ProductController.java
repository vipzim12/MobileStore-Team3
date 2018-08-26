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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.Product;
import com.team3.app.service.CategoryServiceIpm;
import com.team3.app.service.ProductServiceIpm;

@RestController
@RequestMapping("/api/product")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	@Autowired
	private ProductServiceIpm productService;
	
	@Autowired
	private CategoryServiceIpm categoryService;
	
	@GetMapping(value = {"/all"})
	Object viewAll() {
		return productService.getAll();
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	Object getCategory() {
		return categoryService.getAll();
	}

	@PostMapping(value = "/add-new")
	Object addOne(@RequestBody Product product) {
		return productService.insertOne(product);
	}

	@DeleteMapping(value = "/delete/{id}")
	Object deleteOne(@PathVariable int id) {
		return productService.deleteOne(id);
	}

	@PutMapping(value = "/edit")
	Object editOne(@RequestBody Product product) {
		return productService.editOne(product);
	}

	@GetMapping("/edit/{id}")
	Object getOne(@PathVariable("id") int id){
		return productService.getOne(id);
	}
}
