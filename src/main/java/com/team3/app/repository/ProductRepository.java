package com.team3.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.team3.app.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	// @Query(value = "select * from Products p where p.promotion > 0", nativeQuery
	// = true)
	// List<Product> getAllProductSale();

<<<<<<< HEAD
	@Query(value = "select * from Products p where p.promotion is not null", nativeQuery = true)
=======
	@Query(value = "select * from Products p where p.promotion > 0", nativeQuery = true)
>>>>>>> origin/Khoa
	List<Product> getAllProductSale();

	@Query(value = "select Top(8) * from Products p, Category c, Group_Categories gc where p.id_category = c.id_category and c.id_group_category = gc.id_group_category and c.id_group_category = ?1", nativeQuery = true)
	List<Product> gellProByGCategoryId(Integer id);

	@Query(value = "SELECT P FROM Product P ORDER BY P.price ")
	List<Product> getProductSortedAsc();

	@Query(value = "SELECT P FROM Product P ORDER BY P.price DESC")
	List<Product> getProductSortedDesc();

	@Query(value = "select top(3) P.* FROM Products P  JOIN Category  ON Category.id_category=P.id_category "
			+ "INNER JOIN Group_Categories ON Category.id_group_category= Group_Categories.id_group_category "
			+ "WHERE Group_Categories.id_group_category " + "in (SELECT Group_Categories.id_group_category "
			+ "FROM Group_Categories JOIN Category ON Category.id_group_category= Group_Categories.id_group_category "
			+ "Where Category.id_category=?1 )", nativeQuery = true)
	List<Product> getProductsGCategoryByIdCategory(int id);

	@Query(value = "SELECT * FROM Products P where p.name like  '%?1%'", nativeQuery = true)
	List<Product> getProductByName(String key);
	
<<<<<<< HEAD
	@Query(value="SELECT * FROM Products P WHERE P.id_category=?1", nativeQuery = true)
	List<Product> getProductByCategoryId(int id);
=======
	@Query(value = "SELECT * FROM Products P where p.id_category = ?1", nativeQuery = true)
	List<Product> getProductByCategoryId(Integer id);
>>>>>>> origin/Khoa

}
