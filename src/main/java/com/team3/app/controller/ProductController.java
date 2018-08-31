package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.team3.app.entities.Product;
import com.team3.app.service.CategoryServiceIpm;
import com.team3.app.service.ProductServiceIpm;
import com.team3.app.storage.StorageService;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins= {"http://localhost:4200","*"})
public class ProductController {
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

  @GetMapping(value = { "/product_by_gcategory/{id}" })
  Object getAllProByCateId(@PathVariable int id) {
    return productService.gellProByGCategoryId(id);
  }
  
  @GetMapping(value = { "/search/{key}" })
  Object getAllProByName(@PathVariable String key) {
    return productService.getAllProByName(key);
  }
  
  @GetMapping(value = { "/get_products_by_gcategory/{id}" })
  Object getAllProByCateIdCategory(@PathVariable int id) {
    return productService.gellProByGCategoryIdCategory(id);
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

//	List<String> files = new ArrayList<String>();

	@PostMapping("/post")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			storageService.store(file);
//			files.add(file.getOriginalFilename());
			System.out.println("dadsasadasssss");
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
}
