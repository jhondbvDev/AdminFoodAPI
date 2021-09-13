package com.udea.adminfood.api.model;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class InputPlate {

	
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(
			name="id_plate"
			)
	private Plate plate;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(
			name="id_input"
			)
	private Input input;
	
	private Integer quantity;

	public InputPlate() {
		super();
	}

	public InputPlate(Integer id, Plate plate, Input input, Integer quantity) {
		super();
		this.id = id;
		this.plate = plate;
		this.input = input;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plate getPlate() {
		return plate;
	}

	public void setPlate(Plate plate) {
		this.plate = plate;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof InputPlate)) return false;
	        InputPlate that = (InputPlate) o;
	        return Objects.equals(plate.getName(), that.plate.getName()) &&
	                Objects.equals(input.getDescription(), that.input.getDescription())&&
	                Objects.equals(getQuantity(), that.getQuantity());
	              
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(plate.getName(), input.getDescription(),getQuantity());
	    }
	
}
