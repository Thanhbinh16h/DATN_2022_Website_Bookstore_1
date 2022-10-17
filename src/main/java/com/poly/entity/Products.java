package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poly.entity.ProductTypes;
import com.poly.entity.UnitTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8898866533394673382L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private Integer quantity;
	
	@Column
	private Double price;
	
	@Column
	private String imgUrl;
	
	@Column
	private String slug;
	
	@Column
	private String description;
	
	@Column
	private Boolean isDelete;
	
	@ManyToOne
	@JoinColumn(name = "typeId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private ProductTypes productTypes;
	
	@ManyToOne
	@JoinColumn(name = "unitId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private UnitTypes unitTypes;
}
