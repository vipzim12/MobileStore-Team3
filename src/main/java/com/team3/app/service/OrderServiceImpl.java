package com.team3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.Order;
import com.team3.app.repository.OrderRepository;
import com.team3.app.utils.HttpObject;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;

	@Override
	public Object getAll() {
		return new HttpObject(true, repository.findAll());
	}

	@Override
	public Object insertOne(Order order) {
		try {
			repository.save(order);
		} catch (Exception e) {
			return new HttpObject(false, "Add Order Failed");
		}
		return new HttpObject(true, "Add Order successfully");
	}

	@Override
	public Object deleteOne(int id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return new HttpObject(true, "Delete User successfully");
		} else {
			return new HttpObject(false, "User with id=" + id + " do not exists");
		}
	}

	@Override
	public Object editOne(Order order) {
		if (repository.existsById(order.getId())) {
			repository.save(order);
			return new HttpObject(true, "Edit Order successfully");
		} else {
			return new HttpObject(false, "Order with id=" + order.getId() + " do not exists");
		}
	}

}
