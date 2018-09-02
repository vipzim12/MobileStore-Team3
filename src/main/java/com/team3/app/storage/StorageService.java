package com.team3.app.storage;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageService {
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	private final Path rootLocation = Paths.get("upload-dir");
	
	public String store(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
			System.out.println("Khboassasa");
			return file.getOriginalFilename();
		} catch (Exception e) {
			return file.getOriginalFilename();
		}
	}
	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists()||resource.isReadable()) {
				return resource;
			}
			else {
				throw new RuntimeException("FAIL!");
			}
		} catch (Exception e) {
			throw new RuntimeException("Fail!");
		}
	}
	
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
	
	public void init() {
		try {
			if(Files.notExists(rootLocation))
			Files.createDirectory(rootLocation);
		} catch (Exception e) {
			throw new RuntimeException("Could not initialize storage!");
		}
	}
}
