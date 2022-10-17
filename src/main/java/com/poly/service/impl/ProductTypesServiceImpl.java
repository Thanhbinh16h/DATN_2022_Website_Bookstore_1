package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.ProductTypes;
import com.poly.repo.ProductTypesRepo;
import com.poly.service.ProductTypesService;

@Service
public class ProductTypesServiceImpl implements ProductTypesService{
	@Autowired
	private ProductTypesRepo ptrepo;

	@Override
	public List<ProductTypes> fillAll() {
		return ptrepo.findAll();
	}
	
}
