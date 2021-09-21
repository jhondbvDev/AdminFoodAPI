package com.udea.adminfood.api.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "plates")
public class Plate {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String name;
	private double price;
	private Integer id_category;

	@OneToMany(mappedBy = "plate", cascade =  CascadeType.ALL ,orphanRemoval=false,fetch=FetchType.LAZY)
	private Set<InputPlate> inputPlates;

	public Plate() {
	};

	public Plate(Integer id, String description, String name, double price, Integer id_category) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
		this.id_category = id_category;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId_category() {
		return id_category;
	}

	public void setId_category(Integer id_category) {
		this.id_category = id_category;
	}

	public Set<InputPlate> getInputPlate() {
		return inputPlates;
	}

	public void setInputPlate(Set<InputPlate> inputPlates) {
		
		this.inputPlates = inputPlates;
	}

}
