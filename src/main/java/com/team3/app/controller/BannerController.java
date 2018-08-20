package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team3.app.entities.Banner;
import com.team3.app.service.BannerService;

@RestController
@RequestMapping("/pages/banners")
@CrossOrigin("http://localhost:4200")
public class BannerController {

	@Autowired
	BannerService service;

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	Object viewAll() {
		return service.getAll();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	Object addOne(Banner banner) {
		return service.insertOne(banner);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	Object deleteOne(@PathVariable("id") int id) {
		return service.deleteOne(id);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	Object editOne(Banner banner) {
		return service.editOne(banner);
	}
}
