package com.team3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.GroupCategory;
import com.team3.app.repository.GroupCategoryRepository;
import com.team3.app.utils.HttpObject;

@Service
public class GroupCategoriesService implements GroupCategoriesServiceIpm {
	
	@Autowired GroupCategoryRepository repository;
	
	@Override
	public HttpObject getAll() {
		return new HttpObject(true, repository.findAll());
	}

	@Override
	public HttpObject insertOne(GroupCategory gCategory) {
		try {
			repository.save(gCategory);
		} catch (Exception e) {
			new HttpObject(false, "Edit product Failed");
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
	public Object editOne(GroupCategory gCategory) {
		if (repository.existsById(gCategory.getId())) {
			try {
				repository.save(gCategory);
			} catch (Exception e) {
				new HttpObject(false, "Edit banner Failed");
			}
			return new HttpObject(true, "Edit banner successfully");
		} else {
			return new HttpObject(false, "Group Category with id=" + gCategory.getId() + " do not exists");
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
