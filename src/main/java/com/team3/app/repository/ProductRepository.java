package com.team3.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team3.app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = "select * from Products p where p.promotion is not null", nativeQuery = true)
	List<Product> getAllProductSale();

	@Query(value = "select Top(8) * from Products p, Category c, Group_Categories gc where p.id_category = c.id_category and c.id_group_category = gc.id_group_category and c.id_group_category = ?1", 
			nativeQuery = true)
	List<Product> gellProByGCategoryId(Integer id);
	
	@Query(value="SELECT P FROM Product P ORDER BY P.price ")
	List<Product> getProductSortedAsc();
	
	@Query(value="SELECT P FROM Product P ORDER BY P.price DESC")
  List<Product> getProductSortedDesc();
}
