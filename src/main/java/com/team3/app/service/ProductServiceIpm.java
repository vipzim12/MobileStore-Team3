package com.team3.app.service;

import com.team3.app.entities.Product;

public interface ProductServiceIpm {
	Object getAll();

	Object insertOne(Product product);

	Object deleteOne(int id);

	Object editOne(Product product);

	Object getOne(int id);

	Object getAllProductSale();

	Object gellProByGCategoryId(int id);

	Object sortAsc();

	Object sortDesc();

	Object gellProByGCategoryIdCategory(int id);

	Object getAllProByName(String key);
	
	Object getProductByCategoryId(int id);

}
