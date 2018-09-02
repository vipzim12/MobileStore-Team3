package com.team3.app.controller;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> Khoa
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.team3.app.entities.Cart;
import com.team3.app.entities.User;
import com.team3.app.repository.CartRepository;
import com.team3.app.service.UserService;
import com.team3.app.utils.HttpObject;
=======
import com.team3.app.entities.User;
import com.team3.app.service.UserService;
>>>>>>> Khoa

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins= {"http://localhost:4200","*"})
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	Object login(@RequestBody User user) {
		return userService.checkAdmin(user.getUsername(),user.getPassword());
	}
	
	@PostMapping("/client/login")
	Object loginClient(@RequestBody User user) {
		return userService.checkClient(user.getUsername(),user.getPassword());
	}
	
	@PostMapping(value = "/client/registor")
	Object registor(@RequestBody User user) {
		return userService.registorClient(user);
	}
<<<<<<< HEAD
	
=======
>>>>>>> Khoa
}
