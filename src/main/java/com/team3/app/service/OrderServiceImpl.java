package com.team3.app.service;

import java.util.List;

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

  @Override
  public Object getOrderById(int id) {

    return new HttpObject(true, repository.findById(id));
  }

  @Override
  public void deleteOrderByIdOrderDetail(int idOrderDetail) {
    List<Order> mListOrder = repository.findByIdOrderDetail(idOrderDetail);

    for (int i = 0; i < mListOrder.size(); i++) {
      if (repository.existsById(mListOrder.get(i).getId())) {
        repository.deleteById(mListOrder.get(i).getId());
      }
      System.out.println(mListOrder.get(i).toString());
    }

  }
}
