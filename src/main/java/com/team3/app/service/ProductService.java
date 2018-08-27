package com.team3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.Product;
import com.team3.app.repository.ProductRepository;
import com.team3.app.utils.HttpObject;

@Service
public class ProductService implements ProductServiceIpm {
	@Autowired
	ProductRepository repository;

	@Override
	public HttpObject getAll() {
		return new HttpObject(true, repository.findAll());
	}
	
	@Override
	public Object gellProByGCategoryId(int id) {
		return new HttpObject(true, repository.gellProByGCategoryId(id));
	}
	
	@Override
	public HttpObject insertOne(Product product) {
		try {
			repository.save(product);
		} catch (Exception e) {
			new HttpObject(false, "Add product Failed");
		}
		return new HttpObject(true, "Add product successfully");
	}

	@Override
	public Object deleteOne(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return new HttpObject(true, "Delete product successfully");
		} else {
			return new HttpObject(false, "Product with id=" + id + " do not exists");
		}
	}

	@Override
	public Object editOne(Product product) {
		if (repository.existsById(product.getId())) {
			try {
				repository.save(product);
			} catch (Exception e) {
				new HttpObject(false, "Edit banner Failed");
			}
			return new HttpObject(true, "Edit banner successfully");
		} else {
			return new HttpObject(false, "Product with id=" + product.getId() + " do not exists");
		}
	}

	@Override
	public HttpObject getOne(int id) {
		if(repository.existsById(id))
		{
			return new HttpObject(true, repository.findById(id));
		}else {
			return new HttpObject(false, "Product with id="+id + " do not exists");
		}
	}

	@Override
	public Object getAllProductSale() {
		return new HttpObject(true, repository.getAllProductSale()); 
	}


	
}
