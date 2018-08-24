package com.team3.app.service;

import com.team3.app.entities.Order;

public interface OrderService {

  Object getAll();

  Object getOrderById(int id);

  Object insertOne(Order order);

  Object deleteOne(int id);

  void deleteOrderByIdOrderDetail(int idOrderDeatail);

  Object editOne(Order order);

}
