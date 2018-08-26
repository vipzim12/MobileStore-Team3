package com.team3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.Category;
import com.team3.app.repository.CategoryRepository;
import com.team3.app.utils.HttpObject;

@Service
public class CategoryService implements CategoryServiceIpm{
	@Autowired CategoryRepository repository;
	
	@Override
	public HttpObject getAll() {
		return new HttpObject(true, repository.findAll());
	}

	@Override
	public HttpObject insertOne(Category category) {
		try {
			repository.save(category);
		} catch (Exception e) {
			new HttpObject(false, "Edit category Failed");
		}
		return new HttpObject(true, "Add category successfully");
	}

	@Override
	public Object deleteOne(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return new HttpObject(true, "Delete product successfully");
		} else {
			return new HttpObject(false, "Category with id=" + id + " do not exists");
		}
	}

	@Override
	public Object editOne(Category category) {
		if (repository.existsById(category.getId())) {
			try {
				repository.save(category);
			} catch (Exception e) {
				new HttpObject(false, "Edit banner Failed");
			}
			return new HttpObject(true, "Edit banner successfully");
		} else {
			return new HttpObject(false, "Category with id=" + category.getId() + " do not exists");
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
}
