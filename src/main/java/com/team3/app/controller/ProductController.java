package com.team3.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.team3.app.entities.Product;
import com.team3.app.service.CategoryServiceIpm;
import com.team3.app.service.ProductServiceIpm;
import com.team3.app.storage.StorageService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = { "http://localhost:4200", "*" })
public class ProductController {

	private String linkImage = "";
	private boolean isPost = false;

	@Autowired
	private ProductServiceIpm productService;

	@Autowired
	private CategoryServiceIpm categoryService;

	@GetMapping(value = { "/all" })
	Object viewAll() {
		return productService.getAll();
	}

	@GetMapping(value = { "/sale" })
	Object getAllProductSale() {
		return productService.getAllProductSale();
	}
	@GetMapping(value="/product_by_categoryId/{id}")
	Object getAllProductByCategoryID(@PathVariable int id) {
		return productService.getProductByCategoryId(id);
	}
	@GetMapping(value = { "/product_by_gcategory/{id}" })
	Object getAllProByCateId(@PathVariable int id) {
		return productService.gellProByGCategoryId(id);
	}

	@GetMapping(value = { "/get_products_by_gcategory/{id}" })
	Object getAllProByCateIdCategory(@PathVariable int id) {
		return productService.gellProByGCategoryIdCategory(id);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	Object getCategory() {
		return categoryService.getAll();
	}

	@DeleteMapping(value = "/delete/{id}")
	Object deleteOne(@PathVariable int id) {
		return productService.deleteOne(id);
	}

	@GetMapping(value = { "/search/{key}" })
	Object getAllProByName(@PathVariable String key) {
		return productService.getAllProByName(key);
	}

	@PostMapping(value = "/add-new")
	Object addOne(@RequestBody Product product) {
		if (isPost) {
			product.setLinkImage(linkImage);
			System.out.println(linkImage);
			isPost = false;
		}
		return productService.insertOne(product);
	}

	@PutMapping(value = "/edit")
	Object editOne(@RequestBody Product product) {
		if (isPost) {
			product.setLinkImage(linkImage);
			isPost = false;
		}

		return productService.editOne(product);
	}

	@GetMapping("/edit/{id}")
	Object getOne(@PathVariable("id") int id) {
		return productService.getOne(id);
	}

	@GetMapping("/sortAsc")
	Object getSortAsc() {
		return productService.sortAsc();
	}

	@GetMapping("/sortDesc")
	Object getSortDesc() {
		return productService.sortDesc();
	}

	@Autowired
	StorageService storageService;

	List<String> files = new ArrayList<String>();

	@PostMapping("/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

		String message = "";
		try {
			String fileNameGet = storageService.store(file);
			isPost = true;
			System.out.println(fileNameGet + "aaa");
			files.add(fileNameGet);
			System.out.println("dadsasadasssss");
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			List<String> fileNames = files.stream()
					.map(fileName -> MvcUriComponentsBuilder
							.fromMethodName(ProductController.class, "getFile", fileName).build().toString())
					.collect(Collectors.toList());
			files.clear();
			linkImage = fileNames.get(0);
			System.out.println(linkImage + "bbbb");
			return ResponseEntity.ok().body(message);
		} catch (Exception e) {
			message = "http://localhost:8080/api/product/files/" + file.getOriginalFilename();
			if (file.isEmpty()) {
				linkImage = "";
			} else {
				linkImage = message;
			}
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = storageService.loadFile(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

}
