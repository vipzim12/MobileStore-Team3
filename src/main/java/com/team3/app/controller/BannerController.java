package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.Banner;
import com.team3.app.service.BannerService;

@RestController
@RequestMapping("/pages/banner")
@CrossOrigin(origins= {"http://localhost:4200","*"})
public class BannerController {

	@Autowired
	BannerService service;
	
	@GetMapping(value = "/show")
	Object viewAll() {
		return service.getAll();
	}

	@PostMapping(value = "/insert")
	Object addOne(Banner banner) {
		return service.insertOne(banner);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	Object deleteOne(@PathVariable("id")int id) {
		return service.deleteOne(id);
	}
	
	@PutMapping(value = "/edit")
	Object editOne(Banner banner) {
		return service.editOne(banner);
	}
}
