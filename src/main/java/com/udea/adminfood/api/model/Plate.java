package com.udea.adminfood.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"Plates\"")
public class Plate {

	
	  @Id
	  
	  @Column(name = "id")
	  
	  @SequenceGenerator(name = "plate_sequence", sequenceName = "plate_sequence",
	  allocationSize = 1)
	  
	  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	  "plate_sequence") private Integer id; private String description; private
	  double price;
	  
	  public Plate() { };
	  
	  public Integer getId() { return id; }
	  
	  public void setId(Integer id) { this.id = id; }
	  
	  public String getDescription() { return description; }
	  
	  public void setDescription(String description) { this.description =
	  description; }
	  
	  public double getPrice() { return price; }
	  
	  public void setPrice(double price) { this.price = price; }
	  
	  public Plate(Integer id, String description, double price) { this.id = id;
	  this.description = description; this.price = price; }
	 
}
