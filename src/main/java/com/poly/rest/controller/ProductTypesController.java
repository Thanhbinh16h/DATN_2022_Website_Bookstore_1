package com.poly.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.ProductTypes;
import com.poly.service.ProductTypesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/producttypes")
public class ProductTypesController {
	@Autowired
	ProductTypesService productTypesService;
	
	@GetMapping()
	public List<ProductTypes> getAll(){
		return productTypesService.fillAll();
	}
}
