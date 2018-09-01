package com.team3.app;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.team3.app.storage.StorageService;

@SpringBootApplication
public class JpaLearningApplication implements CommandLineRunner{
	@Resource
	StorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(JpaLearningApplication.class, args);
	}
	
	@Override
	public void run(String... arg) throws Exception {
//		storageService.deleteAll();
		storageService.init();
	}
	
}
