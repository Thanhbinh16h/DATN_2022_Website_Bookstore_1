package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product_types")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductTypes implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7624508539284231427L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "slug")
	private String slug;
	
	@Column(name = "disDelete")
	private Boolean isDelete;
}
