package com.team3.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.team3.app.entities.Banner;
import com.team3.app.entities.User;
import com.team3.app.repository.BannerRepository;

@RestController
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
//@RequestMapping("/api")
public class LoginAdminController {
  @Autowired
  BannerRepository repository;

  @RequestMapping("/admin-login")
  public String login() {
    return "Hello Login";
  }

  @RequestMapping(value = "/all")
  public List<Banner> viewAll() {
    return repository.findAll();
  }

  @RequestMapping(value = "/post", method = RequestMethod.POST, consumes="application/json")
  public  String viewAll(User user) {
    System.out.println(user.toString());
    return user.toString();
  }
}
