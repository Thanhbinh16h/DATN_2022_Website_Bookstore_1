package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.poly.entity.Products;
import com.poly.repo.ProductRepo;
import com.poly.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo prepo;
	
	@Override
	public List<Products> findAll() {
		return prepo.findAllAvailable();
	}

	@Override
	public Products findById(Long id) {
		Optional<Products> result = prepo.findById(id);
		return result.isPresent() ? result.get() : null;
	}

	@Override
	public Products findBySlug(String slug) {
		return prepo.findBySlug(slug);
	}

	@Transactional(value =  TxType.REQUIRED)
	@Override
	public void updateQuantity(Integer newQuantity, Long id) {
		prepo.updateQuantity(newQuantity, id);
	}

	@Override
	public Page<Products> findAll(int pageSize, int PageNumber) throws Exception {
		if(PageNumber >= 1) {
			return prepo.findByIsDeleteAndQuantityGreaterThan(Boolean.FALSE,0, PageRequest.of( PageNumber -1 ,pageSize));	
		}else {
			throw new Exception("Page number must be greater than 0");
		}				
	}

	@Override
	public List<Products> findByProductTypes_Id(Long typeId) {
		
		return prepo.findByProductTypes_Id(typeId);
	}

}
