package com.team3.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.OrderDetail;
import com.team3.app.service.OrderDetailService;

@RestController
@RequestMapping("/pages/order-detail")
@CrossOrigin("http://localhost:4200")
public class OrderDetailController {

  @Autowired
  OrderDetailService orderDetailService;

  @RequestMapping(value = "/all", method = RequestMethod.GET)
  Object getAllOrderDetail() {
    return orderDetailService.getAll();
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  Object getOrderDetailById(@PathVariable("id") int id) {
    return orderDetailService.getOrderDetailById(id);
  }

  @RequestMapping(value = "/edit", method = RequestMethod.PUT)
  Object updateOrderDetail(@RequestBody OrderDetail orderDetail) {
    return orderDetailService.UpdateOrderDetail(orderDetail);
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  Object addOrderDetail(@RequestBody OrderDetail orderDetail) {
    return orderDetailService.addOrderDetail(orderDetail);
  }
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  Object deleteOrderDetail(@PathVariable("id") int id) {
    return orderDetailService.deleteOrderDetail(id);
  }
}
