package com.team3.app.service;

import com.team3.app.entities.Category;

public interface CategoryServiceIpm {
	Object getAll();
	Object insertOne(Category category);
	Object deleteOne(int id);
	Object editOne(Category category);
	Object getOne(int id);
}
