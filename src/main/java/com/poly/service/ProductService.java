package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.poly.entity.Products;

public interface ProductService {
	List<Products> findAll();
	Page<Products> findAll(int pageSize, int PageNMumber) throws Exception;

	Products findById(Long id);
	Products findBySlug(String slug);
	void updateQuantity(Integer newQuantity, Long id);
	List<Products> findByProductTypes_Id(Long typeId);
}
