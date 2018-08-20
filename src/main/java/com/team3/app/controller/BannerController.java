//package com.team3.app.controller;
//
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.Optional;
//
//import javax.persistence.EntityNotFoundException;
//import javax.websocket.server.PathParam;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.team3.app.entities.Banner;
//import com.team3.app.repositories.BannerRepository;
//import com.team3.app.services.BannerService;
//import com.team3.app.utils.HttpObject;
//
//@RestController
//@RequestMapping("/banner")
//public class BannerController {
//
//	@Autowired
//	BannerService service;
//	
//	@RequestMapping(value = "/show", method = RequestMethod.GET)
//	Object viewAll() {
//		return service.getAll();
//	}
//
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
//	Object addOne(Banner banner) {
//		return service.insertOne(banner);
//	}
//	
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	Object deleteOne(@PathVariable("id")int id) {
//		return service.deleteOne(id);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
//	Object editOne(Banner banner) {
//		return service.editOne(banner);
//	}
//}
