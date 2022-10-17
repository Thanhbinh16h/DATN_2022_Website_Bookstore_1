package com.poly.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poly.entity.ProductTypes;

@Repository
public interface ProductTypesRepo extends  JpaRepository<ProductTypes, Integer> {
}
