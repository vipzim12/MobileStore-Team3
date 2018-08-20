package com.team3.app.service;

import com.team3.app.entities.Order;
import com.team3.app.entities.User;

public interface OrderService{

	Object getAll();
	Object insertOne(Order order);
	Object deleteOne(int id);
	Object editOne(Order order);
	
}
