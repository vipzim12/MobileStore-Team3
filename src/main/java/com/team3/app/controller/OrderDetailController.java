package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.service.OrderDetailService;

@RestController
@RequestMapping("/pages/order-detail")
@CrossOrigin("http://localhost:4200")
public class OrderDetailController {

	@Autowired
	OrderDetailService orderDetailService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	Object getAllOrderDetail() {
		return orderDetailService.getAll();
	}
	
}
