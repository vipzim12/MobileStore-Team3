package com.team3.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team3.app.entities.Cart;
import com.team3.app.entities.CartId;
import com.team3.app.entities.Product;
import com.team3.app.entities.User;
import com.team3.app.repository.CartRepository;
import com.team3.app.repository.ProductRepository;
import com.team3.app.repository.UserRepository;
import com.team3.app.utils.HttpObject;

@RestController
@RequestMapping("carts")
@CrossOrigin(origins= {"http://localhost:4200","*"})
public class CartController {

	@Autowired
	CartRepository cartRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	ProductRepository productRepo;
	
	@GetMapping("{userId}")
	Object test(@PathVariable(name="userId") int userId) {
		return new HttpObject(true, cartRepo.getCart(userId));
	}
	
	@DeleteMapping("{userId}")
	Object test2(@PathVariable(name="userId") int userId) {
		List<Cart> l = cartRepo.getCart(userId);
		l.forEach(x->{
			cartRepo.deleteById(x.getCartId());
		});
		return new HttpObject(true, "Deleted");
	}
	
	@PostMapping("add/{userId}/{productId}/{quantity}")
	Object test1(@PathVariable(name="userId") int userId,@PathVariable(name="productId") int productId,@PathVariable(name="quantity") int quantity) {
		Optional<User> optU = userRepo.findById(userId);
		boolean flag = false;
		if(optU.isPresent()) {
			List<Cart> list = cartRepo.getCart(userId);
			for (Cart cart : list) {
				if(cart.getCartId().getProduct().getId()==productId) {
					flag = true;
					cart.setQuantity(cart.getQuantity()+quantity);
					cartRepo.save(cart);
					return new HttpObject(true, "Update Cart successfully");
				}
			}
			if(!flag) {
				Optional<Product> optP = productRepo.findById(productId);
				if(optP.isPresent()) {
					Cart x = new Cart();
					CartId y = new CartId();
					y.setUser(optU.get());
					y.setProduct(optP.get());
					x.setCartId(y);
					x.setQuantity(quantity);
					cartRepo.save(x);
					return new HttpObject(true, "Add into Cart successfully");
				}else {
					return new HttpObject(false, "Product does not exists");
				}
			}
		}
		return new HttpObject(false, "User does not exists");
	}
	
}
