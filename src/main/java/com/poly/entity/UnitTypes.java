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
import lombok.Setter;

@Entity
@Table(name = "unit_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UnitTypes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690476462593186230L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;

	
	@Column(name = "disDelete")
	private Boolean isDelete;
}