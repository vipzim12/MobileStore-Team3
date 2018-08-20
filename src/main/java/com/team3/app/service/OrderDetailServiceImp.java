package com.team3.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team3.app.entities.OrderDetail;
import com.team3.app.repository.OrderDetailRepository;
import com.team3.app.utils.HttpObject;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public Object getAll() {
		return new HttpObject(true, orderDetailRepository.findAll());
	}

	@Override
	public Object insertOne(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deleteOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object editOne(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

}
