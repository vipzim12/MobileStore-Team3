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
  @Autowired
  OrderService orderService;

  @Override
  public Object getAll() {
    return new HttpObject(true, orderDetailRepository.findAll());
  }

  @Override
  public Object getOrderDetailById(int id) {

    return new HttpObject(true, orderDetailRepository.findById(id));
  }

  @Override
  public Object addOrderDetail(OrderDetail orderDetail) {
    try {
      orderDetailRepository.save(orderDetail);

    } catch (Exception e) {
      return new HttpObject(false, "add order detail fail!");
    }
    return new HttpObject(true, "add successfully");
  }

  @Override
  public Object deleteOrderDetail(int id) {
    if (orderDetailRepository.existsById(id)) {
      orderService.deleteOrderByIdOrderDetail(id);
      orderDetailRepository.deleteById(id);
      return new HttpObject(true, "Delete Successfully!");
    }
    return new HttpObject(false, "Delete Fail!");
  }

  @Override
  public Object UpdateOrderDetail(OrderDetail orderDetail) {
    if (orderDetailRepository.existsById(orderDetail.getId())) {
      orderDetailRepository.save(orderDetail);
      return new HttpObject(true, "Edit Order Detail successfully");
    } else {
      return new HttpObject(false,
          "Order Detail with id=" + orderDetail.getId() + " do not exists");
    }
  }

  @Override
  public Boolean isExistDetailOrder(int idOrderDetail) {
    if (orderDetailRepository.existsById(idOrderDetail)) {
      return true;
    }
    return false;
  }

}
