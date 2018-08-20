package com.team3.app.service;

import com.team3.app.entities.OrderDetail;


public interface OrderDetailService {
	
	Object getAll();

	Object insertOne(OrderDetail orderDetail);

	Object deleteOne(int id);

	Object editOne(OrderDetail orderDetail);
}
