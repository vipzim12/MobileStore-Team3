package com.team3.app.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team3.app.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
 
  @Query("SELECT o FROM Order o WHERE o.idOrderDetail = ?1")
  public List<Order> findByIdOrderDetail(int id_order_detail);
  
}
