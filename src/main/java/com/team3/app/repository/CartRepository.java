package com.team3.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.team3.app.entities.Cart;
import com.team3.app.entities.CartId;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId>{
	@Query("select c from Cart c where c.cartId.user.id = ?1")
	List<Cart> getCart(int userId);
}
