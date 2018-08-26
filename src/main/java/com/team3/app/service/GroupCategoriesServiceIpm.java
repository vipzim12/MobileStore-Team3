package com.team3.app.service;

import com.team3.app.entities.GroupCategory;

public interface GroupCategoriesServiceIpm {
	Object getAll();
	Object insertOne(GroupCategory gCategory);
	Object deleteOne(int id);
	Object editOne(GroupCategory gCategory);
	Object getOne(int id);
}
