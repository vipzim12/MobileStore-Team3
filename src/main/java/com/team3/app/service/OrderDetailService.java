package com.team3.app.service;

import com.team3.app.entities.OrderDetail;

public interface OrderDetailService {

  Boolean isExistDetailOrder(int idOrderDetail);

  Object getAll();

  Object getOrderDetailById(int id);

  Object addOrderDetail(OrderDetail orderDetail);

  Object deleteOrderDetail(int id);

  Object UpdateOrderDetail(OrderDetail orderDetail);
}
