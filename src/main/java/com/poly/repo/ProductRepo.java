package com.poly.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.poly.entity.Products;

@Repository
public interface ProductRepo extends  JpaRepository<Products, Long> {
	
	@Query("SELECT p FROM Products p WHERE p.productTypes.id=?1")
	List<Products> findByProductTypes_Id(Long typeId);
	//Select * from products where typeId = ?
	
	Products findBySlug(String slug);
	//Select * from products where slugId = ?
	
	@Query(value = "select * from products where isDeleted = 0 and quantity > 0", nativeQuery = true)
	List<Products> findAllAvailable();

	List<Products> findByIsDeleteAndQuantityGreaterThan(Boolean isDeleted, Integer quantity);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE products SET quantity = ?1 WHERE id = ?2", nativeQuery = true)
	void updateQuantity(Integer newQuantity, Long id);
	
	Page<Products> findByIsDeleteAndQuantityGreaterThan(Boolean isDeleted, Integer quantity, Pageable pageable);

}
